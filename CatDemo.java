package cat.shelter;

public class CatDemo {

    public static void main(String[] args) throws MeowException {

        Cat c1 = new Cat.Builder()
                .setbId(20012900)
                .setbTagCode("TKY2007C02275")
                .setbBreed("Scottish Fold (Straight)")
                .setbColor("Tabby/White")
                .setbName("MARU")
                .setbAge(12)
                .setbHealthIssues("health check on Feb 5")
                .setbIsAdoptionReady(false)
                .setbHasNewOwner(false)
                .build();

        Cat c2 = new Cat.Builder()
                .setbId(20012901)
                .setbColor("Red")
                .setbName("TOSYA")
                .setbAge(8)
                .setbHealthIssues("kidneys (minor), pancreas (minor)")
                .setbIsAdoptionReady(false)
                .setbHasNewOwner(true)
                .build();

        Cat c3 = new Cat.Builder()
                .setbId(20012902)
                .setbTagCode("NYC2017C13477")
                .setbBreed("Golden British Shorthair")
                .setbColor("Red")
                .setbName("PISCO")
                .setbAge(3)
                .setbHealthIssues("no issues, checked Jan 3")
                .setbIsAdoptionReady(true)
                .setbHasNewOwner(false)
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
