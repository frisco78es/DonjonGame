package fil.coo.adventure.places;

public enum EnumRoom {
        BALROGROM(new BalrogRoom(), 0.05) {
    
            @Override
            public Room getRoom() {
                return this.room;
            }
        },
    
        GOBLIN(new GoblinRoom(), 0.5) {
    
            @Override
            public Room getRoom() {
                return this.room;
            }
        },
    
        SLIME(new SlimeRoom(), 0.2) {
    
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
    
        LOOTER(new LooterRoom(), 0.1) {
    
            @Override
            public Room getRoom() {
                return this.room;
            }
        },
    
        KRAKEN(new KrakenRoom(), 0.05) {
    
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
        public double getCoef() {
            return this.coef;
        };
    }
