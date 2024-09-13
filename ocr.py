import pypandoc
from flask import Flask, render_template, request, redirect, url_for, send_from_directory
from werkzeug.utils import secure_filename
import os
from nougat_ocr import NougatOCR

app = Flask(__name__)

# 配置上传文件夹
UPLOAD_FOLDER = 'uploads/'
app.config['UPLOAD_FOLDER'] = UPLOAD_FOLDER

# 确保上传文件夹存在
if not os.path.exists(UPLOAD_FOLDER):
    os.makedirs(UPLOAD_FOLDER)

# 初始化 NougatOCR
ocr = NougatOCR()

@app.route('/')
def upload_form():
    return '''
    <!doctype html>
    <title>Upload Document</title>
    <h1>Upload a PDF document for OCR</h1>
    <form method=post enctype=multipart/form-data>
      <input type=file name=file>
      <input type=submit value=Upload>
    </form>
    '''

@app.route('/', methods=['POST'])
def upload_file():
    if 'file' not in request.files:
        return 'No file part'
    
    file = request.files['file']
    
    if file.filename == '':
        return 'No selected file'
    
    if file:
        filename = secure_filename(file.filename)
        filepath = os.path.join(app.config['UPLOAD_FOLDER'], filename)
        file.save(filepath)

        # 使用 NougatOCR 进行 OCR 识别
        recognized_mmd = ocr.recognize(filepath)

        # 将识别结果保存为 markdown 文件
        mmd_filename = os.path.splitext(filename)[0] + '.md'
        mmd_filepath = os.path.join(app.config['UPLOAD_FOLDER'], mmd_filename)
        
        with open(mmd_filepath, 'w', encoding='utf-8') as mmd_file:
            mmd_file.write(recognized_mmd)

        # 将 MultiMarkdown 转换为 Word
        word_filename = os.path.splitext(filename)[0] + '.docx'
        word_filepath = os.path.join(app.config['UPLOAD_FOLDER'], word_filename)
        pypandoc.convert_file(mmd_filepath, 'docx', outputfile=word_filepath)

        return f'OCR complete. <a href="/uploads/{word_filename}">Download the Word document</a>'

@app.route('/uploads/<filename>')
def uploaded_file(filename):
    return send_from_directory(app.config['UPLOAD_FOLDER'], filename)

if __name__ == '__main__':
    app.run(debug=True)
