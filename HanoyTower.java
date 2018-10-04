public class HanoyTower {
    private static int counter = 1;

    public static void main(String[] args) {

        int n = 6;

        String firstKernel = "first kernel";
        String secondKernel = "second kernel";
        String thirdKernel = "third kernel";

        moveTower(n, firstKernel, secondKernel, thirdKernel);

    }

    private static void move(String kernelFrom, String kernelTo) {
        System.out.println(counter + ". Move disk from " + kernelFrom + " to " + kernelTo);
        counter++;
    }

    private static void moveTower(int countDisk, String kernelFrom, String kernelTo, String kernelTemp) {

        if (countDisk == 0) return;
        moveTower(countDisk - 1, kernelFrom, kernelTemp, kernelTo);
        move(kernelFrom, kernelTo);
        moveTower(countDisk - 1, kernelTemp, kernelTo, kernelFrom);
    }

}
