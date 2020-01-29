package cat.shelter;

/**
 * Allows to create, save and display records of cats living or lived in a cat shelter
 *
 * @author Aryeh Marnyansky
 * @version 0.1b
 * @see Cat
 */
public class Cat {
    /**
     * Cat fields
     */
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
     * @param id              - internal (shelter) ID of a cat, syntax: [YYMMDD][ID]
     * @param tagCode         - code/ID from cat's microchip implant (IC), retrieved by using RFID device
     * @param breed           - cat breed
     * @param color           - cat color
     * @param name            - cat name given by previous owner or shelter worker
     * @param age             - actual or approx. cat age
     * @param healthIssues    - cat's health issues, if any. Option: date of next cat's health check
     * @param isAdoptionReady - "true" if cat is ready for adoption
     * @param hasNewOwner     - "true" if cat is already has new owner
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
     * Method displays single Cat instance (record)
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
         * Setter for Cat ID field
         *
         * @param id - internal (shelter) ID of a cat, syntax: [YYMMDD][ID]
         * @return link to the current instance of Cat.Builder
         */
        public Builder setId(int id) {
            this.bId = id;
            return this;
        }

        /**
         * Setter for Cat tagCode field
         *
         * @param tagCode - code/ID from cat's microchip implant (IC), retrieved by using RFID device
         * @return link to the current instance of Cat.Builder
         */
        public Builder setTagCode(String tagCode) {
            this.bTagCode = tagCode;
            return this;
        }

        /**
         * Setter for Cat breed field
         *
         * @param breed - cat breed
         * @return link to the current instance of Cat.Builder
         */
        public Builder setBreed(String breed) {
            this.bBreed = breed;
            return this;
        }

        /**
         * Setter for Cat color field
         *
         * @param color - cat color
         * @return link to the current instance of Cat.Builder
         */
        public Builder setColor(String color) {
            this.bColor = color;
            return this;
        }

        /**
         * Setter for Cat name field
         *
         * @param name - cat name given by previous owner or shelter worker
         * @return link to the current instance of Cat.Builder
         */
        public Builder setName(String name) {
            this.bName = name;
            return this;
        }

        /**
         * Setter for Cat age field
         *
         * @param age - actual or approx. cat age
         * @return link to the current instance of Cat.Builder
         */
        public Builder setAge(int age) {
            this.bAge = age;
            return this;
        }

        /**
         * Setter for Cat healthIssues field
         *
         * @param healthIssues - cat's health issues, if any. Option: date of next cat's health check
         * @return link to the current instance of Cat.Builder
         */
        public Builder setHealthIssues(String healthIssues) {
            this.bHealthIssues = healthIssues;
            return this;
        }

        /**
         * Setter for Cat isAdoptionReady field
         *
         * @param isAdoptionReady - "true" if cat is ready for adoption
         * @return link to the current instance of Cat.Builder
         */
        public Builder setIsAdoptionReady(boolean isAdoptionReady) {
            this.bIsAdoptionReady = isAdoptionReady;
            return this;
        }

        /**
         * Setter for Cat hasNewOwner field
         *
         * @param hasNewOwner - "true" if cat is already has new owner
         * @return link to the current instance of Cat.Builder
         */
        public Builder setHasNewOwner(boolean hasNewOwner) {
            this.bHasNewOwner = hasNewOwner;
            return this;
        }

        /**
         * Setter for Cat hasNewOwner field
         *
         * @return new instance of Cat based on current instance of Cat.Builder chain
         * @throws MeowException - thrown if Cat ID, Cat tag code or/and Cat color
         *                       do not match special criteria {@link CatValidator#CatValidator}
         */
        public Cat build() throws MeowException {
            return new Cat(bId, bTagCode, bBreed, bColor,
                    bName, bAge, bHealthIssues, bIsAdoptionReady, bHasNewOwner);
        }
    }

}