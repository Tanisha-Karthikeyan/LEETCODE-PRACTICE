class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        if (s == null || s.length() == 0 || words.length == 0) {
            return result;
        }

        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        int wordLen = words[0].length();
        int wordCount = words.length;

        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int matched = 0;
            Map<String, Integer> window = new HashMap<>();

            for (int right = i; right + wordLen <= s.length(); right += wordLen) {
                String word = s.substring(right, right + wordLen);

                if (count.containsKey(word)) {
                    window.put(word, window.getOrDefault(word, 0) + 1);
                    matched++;

                    while (window.get(word) > count.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        window.put(leftWord, window.get(leftWord) - 1);
                        left += wordLen;
                        matched--;
                    }

                    if (matched == wordCount) {
                        result.add(left);

                        String leftWord = s.substring(left, left + wordLen);
                        window.put(leftWord, window.get(leftWord) - 1);
                        left += wordLen;
                        matched--;
                    }
                } else {
                    window.clear();
                    matched = 0;
                    left = right + wordLen;
                }
            }
        }

        return result;
    }
}