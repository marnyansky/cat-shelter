package cat.shelter;

public class Cat {

    private int id;
    private String tagCode;
    private String breed;
    private String color;
    private String name;
    private int age;
    private String healthIssues;
    private boolean isAdoptionReady;
    private boolean hasNewOwner;

    private Cat(int id, String tagCode, String breed, String color, String name, int age,
                String healthIssues, boolean isAdoptionReady, boolean hasNewOwner) throws MeowException {
        new CatValidator(id, tagCode, color);
        this.id = id;
        this.tagCode = tagCode;
        this.breed = breed;
        this.color = color;
        this.name = name;
        this.age = age;
        this.healthIssues = healthIssues;
        this.isAdoptionReady = isAdoptionReady;
        this.hasNewOwner = hasNewOwner;
    }

    @Override
    public String toString() {
        return "#" + id + "\t" + "tag!" + tagCode + "\t" + "(" + breed + "," + "\t" + color + ")" + "\t"
                + name + "," + "\t" + age + "y" + "\t" + "<" + healthIssues + ">" + "\t"
                + "\t" + "ready?" + isAdoptionReady + "\t" + "adopted?" + hasNewOwner;
    }

    public static class Builder {
        private int bId;
        private String bTagCode = "HasNoTag";
        private String bBreed = "?breed";
        private String bColor;
        private String bName = "?name";
        private int bAge = -1;
        private String bHealthIssues = "?health";
        private boolean bIsAdoptionReady = false;
        private boolean bHasNewOwner = false;

        public Builder setbId(int bId) {
            this.bId = bId;
            return this;
        }

        public Builder setbTagCode(String bTagCode) {
            this.bTagCode = bTagCode;
            return this;
        }

        public Builder setbBreed(String bBreed) {
            this.bBreed = bBreed;
            return this;
        }

        public Builder setbColor(String bColor) {
            this.bColor = bColor;
            return this;
        }

        public Builder setbName(String bName) {
            this.bName = bName;
            return this;
        }

        public Builder setbAge(int bAge) {
            this.bAge = bAge;
            return this;
        }

        public Builder setbHealthIssues(String bHealthIssues) {
            this.bHealthIssues = bHealthIssues;
            return this;
        }

        public Builder setbIsAdoptionReady(boolean bIsAdoptionReady) {
            this.bIsAdoptionReady = bIsAdoptionReady;
            return this;
        }

        public Builder setbHasNewOwner(boolean bHasNewOwner) {
            this.bHasNewOwner = bHasNewOwner;
            return this;
        }

        public Cat build() throws MeowException {
            return new Cat(bId, bTagCode, bBreed, bColor,
                    bName, bAge, bHealthIssues, bIsAdoptionReady, bHasNewOwner);
        }
    }

}