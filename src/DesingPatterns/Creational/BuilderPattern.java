package DesingPatterns.Creational;

class School{
    private String name; // required

    // optional
    private String medium;
    private int staffCount;
    private String board;
    private String type;
    private String address;

    private School(Builder builder){
        this.name = builder.name;
        this.medium = builder.medium;
        this.staffCount = builder.staffCount;
        this.board = builder.board;
        this.type = builder.type;
        this.address = builder.address;
    }

    public static class Builder{
        private String name; // required

        // optional
        private String medium;
        private int staffCount;
        private String board;
        private String type;
        private String address;

        Builder(String name){
            this.name = name;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder medium(String medium){
            this.medium = medium;
            return this;
        }

        public Builder staffCount(int staffCount){
            this.staffCount = staffCount;
            return this;
        }

        public Builder board(String board){
            this.board = board;
            return this;
        }

        public Builder type(String type){
            this.type = type;
            return this;
        }

        public Builder address(String address){
            this.address = address;
            return this;
        }

        public School build(){
            return new School(this);
        }

    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", medium='" + medium + '\'' +
                ", staffCount=" + staffCount +
                ", board='" + board + '\'' +
                ", type='" + type + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}


public class BuilderPattern {
    public static void main(String[] args) {
        School school = new School.Builder("Vidhya Mandir").address("Indore").medium("Hindi").board("CBSC").staffCount(100).build();
        System.out.println(school.toString());
    }
}
