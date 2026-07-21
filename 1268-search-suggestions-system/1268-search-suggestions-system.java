class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);

        List<List<String>> result = new ArrayList<>();
        String prefix = "";

        for (char ch : searchWord.toCharArray()) {
            prefix += ch;

            int index = lowerBound(products, prefix);
            List<String> list = new ArrayList<>();

            for (int i = index; i < Math.min(index + 3, products.length); i++) {
                if (products[i].startsWith(prefix)) {
                    list.add(products[i]);
                } else {
                    break;
                }
            }

            result.add(list);
        }

        return result;
    }

    private int lowerBound(String[] products, String target) {
        int left = 0;
        int right = products.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (products[mid].compareTo(target) < 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}