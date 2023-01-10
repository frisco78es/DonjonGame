package fil.coo.adventure.places.entity;

import fil.coo.adventure.places.Room;

public enum EnumRoom {
    BALROGROM(new BalrogRoom(), 0.1) {

        @Override
        public Room getRoom() {
            return this.room;
        }
    },

    GOBLIN(new GoblinRoom(), 0.1) {

        @Override
        public Room getRoom() {
            return this.room;
        }
    },

    SLIME(new SlimeRoom(), 0.1) {

        @Override
        public Room getRoom() {
            return this.room;
        }
    },

    ORC(new OrcRoom(), 0.1) {

        @Override
        public Room getRoom() {
            return this.room;
        }
    },

    Starting(new StartingRoom(), 0.1) {

        @Override
        public Room getRoom() {
            return this.room;
        }
    },

    LOOTER(new LooterRoom(), 0.1) {

        @Override
        public Room getRoom() {
            return this.room;
        }
    },

    ZOMBIEHORD(new ZombieHordRoom(), 0.1) {

        @Override
        public Room getRoom() {
            return this.room;
        }
    },

    KRAKEN(new KrakenRoom(), 0.1) {

        @Override
        public Room getRoom() {
            return this.room;
        }
    };

    protected final Room room;

    public final double coef;

    EnumRoom(Room r, double c) {
        this.room = r;
        this.coef = c;
    };

    public abstract Room getRoom();
}
