public class DivideAndConquer {
    public static void main(String[] args) {
        var nums = new int[]{0,0,3,2,3,6};
        int target = 1;
        System.out.println(divideAndConquerSearch(nums,target,0, nums.length-1));
    }


    /**
     * Utilizando la técnica "divide y vencerás", desarrollar un algoritmo que, dado un vector de n elementos y un número entero m, determine si existe v[m]=m.
     */
    public static boolean divideAndConquerSearch(int[] nums, int target, int left, int right) {
        // Edge case
        if (target > nums.length-1 || target < 0) {
            return false;
        }

        // Caso base: un solo elemento
        if (left == right) {
            return nums[target] == target;
        }

        int mid = (left + right) / 2;

        // Divide y resuelve ambos lados
        boolean leftResult = divideAndConquerSearch(nums, target, left, mid);
        boolean rightResult = divideAndConquerSearch(nums, target, mid + 1, right);

        // Combinar las respuestas
        return leftResult || rightResult;
    }
}
