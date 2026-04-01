class ProductOfNumbers {

    ArrayList<Integer> prod;
    int n;

    public ProductOfNumbers() {
        prod = new ArrayList<>();
        n = 0;
    }

    public void add(int num) {
        if (num == 0) {
            prod = new ArrayList<>();
            n = 0;
        } else {
            if (prod.isEmpty())
                prod.add(num);
            else
                prod.add(prod.get(n - 1) * num);
                
            n++;
        }
    }

    public int getProduct(int k) {
        if (n < k)
            return 0; // empty array bcz of zero
        else if (n == k)
            return prod.get(n - 1); // 0 base index
        return prod.get(n - 1) / prod.get(n - k - 1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */