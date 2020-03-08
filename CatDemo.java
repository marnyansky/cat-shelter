/**
 * Application demo
 */
public class CatDemo {

    /**
     * Method main() in runtime creates three instances of Cat using Cat.Builder, displays them on console
     *
     * @throws MeowException - thrown if Cat ID, Cat tag code or/and Cat color
     *                       do not match special criteria {@link CatValidator#CatValidator}
     */
    public static void main(String[] args) throws MeowException {

        Cat c1 = new Cat.Builder()
                // TODO use LocalDate class while building id. It is user-friendly.
                .setId(20030800)
                .setTagCode("TKY2007C02275")
                .setBreed("Scottish Fold (Straight)")
                .setColor("Tabby/White")
                .setName("MARU")
                .setAge(12)
                .setHealthIssues("health check on Feb 5")
                .setIsAdoptionReady(false)
                .setHasNewOwner(false)
                .build();

        Cat c2 = new Cat.Builder()
                .setId(20030801)
                .setColor("Red")
                .setName("TOSYA")
                .setAge(8)
                .setHealthIssues("kidneys (minor), pancreas (minor)")
                .setIsAdoptionReady(false)
                .setHasNewOwner(true)
                .build();

        Cat c3 = new Cat.Builder()
                .setId(20030802)
                .setTagCode("NYC2017C13477")
                .setBreed("Golden British Shorthair")
                .setColor("Red")
                .setName("PISCO")
                .setAge(3)
                .setHealthIssues("no issues, checked Mar 8")
                .setIsAdoptionReady(true)
                .setHasNewOwner(false)
                .build();

        CatBox box = new CatBox();
        box.add(c1);
        box.add(c2);
        box.add(c3);
        for (Cat c : box) {
            System.out.println(c);
        }

    }

}