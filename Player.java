public class Player {

    private int bank;

    public String character1;
    public String character2;

    public Player(String c1, String c2) {
        character1 = c1;
        character2 = c2;
    }

    public void action(String action, Player player) {
        switch (action) {
            case "steal":
                if (bank < 10) {
                    bank += 2;
                    player.steal(this);
                }
                break;
            case "income":
                if (bank < 10) {
                    bank++;
                }
                break;
            case "foreign aid":
                if (bank < 10) {
                    bank += 2;
                }
                break;
            case "tax":
                if (bank < 10) {
                    bank += 3;
                }
                break;
            case "assassinate":
                if (bank > 2) {
                    bank -= 3;

                }
                break;
        }

    }

    public int steal(Player player) {
        // Prompt player here
        if ("accept") {
            return stealAccept();
        } else {
            if (player.callOut(this)) {
                return 0;
            } else {
                return stealAccept();
            }
        }
    }

    public boolean callOut(Player player) {
        if (character1.equals("Captain") || character2.equals("Captain")) {
            return false;
        }
    }

    public int stealAccept() {
        if (bank > 1) {
            bank -= 2;
            return 2;
        } else {
            bank = 0;
            return 1;
        }
    }

    public void stealCallOut() {

    }
    
    public int checkBank() {
        return bank;
    }
    
}