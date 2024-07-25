package searchcode;

public class Main10 {
    //task 4 Server Investment
    public static void main(String[] args) {
        int[] num_servers = {4, 3};
        int[] money = {8, 9};
        int[] upgrade = {4, 5};
        int[] sell = {4, 2};

        int[] result = maximizeUpgradedServers(num_servers, money, upgrade, sell);
        for (int upgrades : result) {
            System.out.println(upgrades);
        }
    }

    public static int[] maximizeUpgradedServers(int[] num_servers, int[] money, int[] upgrade, int[] sell) {
        int[] maxUpgraded = new int[num_servers.length];

        for (int i = 0; i < num_servers.length; i++) {
            int currentMoney = money[i];
            int serversUpgraded = 0;
            int serversAvailable = num_servers[i];
            while (serversAvailable > 0 && (currentMoney + sell[i] - upgrade[i] >= upgrade[i] || currentMoney < upgrade[i])) {
                if (currentMoney < upgrade[i]) {
                    currentMoney += sell[i];
                    serversAvailable--;
                }

                while (serversAvailable > 0 && currentMoney >= upgrade[i]) {
                    serversUpgraded++;
                    serversAvailable--;
                    currentMoney -= upgrade[i];
                }
            }
            maxUpgraded[i] = serversUpgraded;
        }
        return maxUpgraded;
    }
}

