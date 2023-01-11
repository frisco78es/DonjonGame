package fil.coo.adventure.places.entity;

import fil.coo.adventure.places.Room;

public enum EnumRoom {
        BALROG(0.05) {
    
            @Override
            public Room getRoom() {
                return new BalrogRoom();
            }
        },
    
        GOBLIN(0.39) {
    
            @Override
            public Room getRoom() {
                return new GoblinRoom();
            }
        },
    
        SLIME(0.2) {
    
            @Override
            public Room getRoom() {
                return new SlimeRoom();
            }
        },
    
        ORC(0.1) {
    
            @Override
            public Room getRoom() {
                return new OrcRoom();
            }
        },
    
        LOOTER(0.1) {
    
            @Override
            public Room getRoom() {
                return new LooterRoom();
            }
        },
    
        KRAKEN(0.05) {
    
            @Override
            public Room getRoom() {
                return new KrakenRoom();
            }
        },

        ZOMBIE(0.1) {
            @Override
            public Room getRoom() {
                return new ZombieHordRoom();
            }
        },

        TRAPPED(0.01) {
            @Override
            public Room getRoom() {
                return new TrappedRoom();
            }
        };
    
        public final double coef;
    
        EnumRoom(double c) {
            this.coef = c;
        };
    
        public abstract Room getRoom();
        public double getCoef() {
            return this.coef;
        };
    }
