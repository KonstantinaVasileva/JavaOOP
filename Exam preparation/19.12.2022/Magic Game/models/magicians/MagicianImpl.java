package OOP.ExamPreparation.Dec19_2022.magicGame.models.magicians;

import OOP.ExamPreparation.Dec19_2022.magicGame.models.magics.Magic;

import static OOP.ExamPreparation.Dec19_2022.magicGame.common.ExceptionMessages.*;

public abstract class MagicianImpl implements Magician {
    private String username;
    private int health;
    private int protection;
    private boolean isAlive;
    private Magic magic;

    public MagicianImpl(String username, int health, int protection, Magic magic) {
        setUsername(username);
        setHealth(health);
        setProtection(protection);
        this.isAlive = true;
        setMagic(magic);
    }

    public void setUsername(String username) {
        if (username == null || username.isBlank()) {
            throw new NullPointerException(INVALID_MAGICIAN_NAME);
        }
        this.username = username;
    }

    public void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(INVALID_MAGICIAN_HEALTH);
        }
        this.health = health;
    }

    public void setProtection(int protection) {
        if (protection < 0) {
            throw new IllegalArgumentException(INVALID_MAGICIAN_PROTECTION);
        }
        this.protection = protection;
    }

    public void setMagic(Magic magic) {
        if (magic == null) {
            throw new NullPointerException(INVALID_MAGIC);
        }
        this.magic = magic;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getProtection() {
        return protection;
    }

    @Override
    public Magic getMagic() {
        return magic;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public void takeDamage(int points) {
        protection -= points;
        if (protection < 0){
            points = Math.abs(protection);
            protection = 0;
            health -= points;
        }
        if (health <=0){
            isAlive = false;
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("%s: ").append(username).append(System.lineSeparator());
        output.append("Health: ").append(health).append(System.lineSeparator());
        output.append("Protection: ").append(protection).append(System.lineSeparator());
        output.append("Magic: ").append(magic.getName()).append(System.lineSeparator());
        //"{magician type}: {magician username}
        // Health: {magician health}
        // Protection: {magician protection}
        // Magic: {magician magic name}"

        return output.toString().trim();
    }
}
