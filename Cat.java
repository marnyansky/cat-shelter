/**
 * Allows to create, save and display records of cats living or lived in a cat shelter
 *
 * @author Aryeh Marnyansky
 * @version 0.1b2
 */
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

    /**
     * private constructor for creating Cat instances
     *
     * @param id           - shelter's internal ID of a cat, syntax: [YYMMDD][ID]
     * @param tagCode      - code/ID from cat's microchip implant (IC) retrieved by using RFID device
     * @param name         - cat name given by previous owner or shelter worker
     * @param age          - actual or approximate cat age
     * @param healthIssues - cat's health issues, if any (of date of next cat's health check)
     * @throws MeowException - thrown if Cat ID, Cat tag code or/and Cat color
     *                       do not match special criteria {@link CatValidator#CatValidator}
     */
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

    /**
     * Method displays single set of Cat instance fields
     */
    @Override
    public String toString() {
        return "#" + id + "\t" + "tag!" + tagCode + "\t" + "(" + breed + "," + "\t" + color + ")" + "\t"
                + name + "," + "\t" + age + "y" + "\t" + "<" + healthIssues + ">" + "\t"
                + "\t" + "ready?" + isAdoptionReady + "\t" + "adopted?" + hasNewOwner;
    }

    /**
     * static nested Builder class that allows to set values of Cat instance fields
     */
    public static class Builder {
        /**
         * Cat.Builder fields that match corresponding Cat fields {@link Cat}
         */
        private int bId;
        private String bTagCode = "HasNoTag";
        private String bBreed = "?breed";
        private String bColor;
        private String bName = "?name";
        private int bAge = -1;
        private String bHealthIssues = "?health";
        private boolean bIsAdoptionReady = false;
        private boolean bHasNewOwner = false;

        /**
         * Set of fields setters
         * @return link to the current instance of Cat.Builder
         */
        public Builder setId(int id) {
            this.bId = id;
            return this;
        }

        public Builder setTagCode(String tagCode) {
            this.bTagCode = tagCode;
            return this;
        }

        public Builder setBreed(String breed) {
            this.bBreed = breed;
            return this;
        }

        public Builder setColor(String color) {
            this.bColor = color;
            return this;
        }

        public Builder setName(String name) {
            this.bName = name;
            return this;
        }

        public Builder setAge(int age) {
            this.bAge = age;
            return this;
        }

        public Builder setHealthIssues(String healthIssues) {
            this.bHealthIssues = healthIssues;
            return this;
        }

        public Builder setIsAdoptionReady(boolean isAdoptionReady) {
            this.bIsAdoptionReady = isAdoptionReady;
            return this;
        }

        public Builder setHasNewOwner(boolean hasNewOwner) {
            this.bHasNewOwner = hasNewOwner;
            return this;
        }

        /**
         * Cat instance creation method
         *
         * @return new instance of Cat using Cat.Builder fields values
         * @throws MeowException - thrown if Cat ID, Cat tag code or/and Cat color
         *                       do not match special criteria {@link CatValidator#CatValidator}
         */
        public Cat build() throws MeowException {
            return new Cat(bId, bTagCode, bBreed, bColor,
                    bName, bAge, bHealthIssues, bIsAdoptionReady, bHasNewOwner);
        }
    }

}