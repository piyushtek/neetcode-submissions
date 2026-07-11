class Solution {
    Map<Character, Set<Character>> graph = new HashMap<>();
    StringBuilder res = new StringBuilder();

    // 0 = unvisited, 1 = visiting, 2 = visited
    int[] visited = new int[26];

    public String foreignDictionary(String[] words) {
        // Add all unique characters to the graph
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
            }
        }

        // Build graph from adjacent words
        for (int i = 1; i < words.length; i++) {
            String w1 = words[i - 1];
            String w2 = words[i];

            if (!process(w1, w2)) {
                return "";
            }
        }

        // DFS every character
        for (char c : graph.keySet()) {
            if (visited[c - 'a'] == 0) {
                if (dfs(c)) {
                    return "";
                }
            }
        }

        return res.reverse().toString();
    }

    // Returns true if cycle is found
    private boolean dfs(char node) {
        int idx = node - 'a';

        if (visited[idx] == 1) {
            return true; // cycle
        }

        if (visited[idx] == 2) {
            return false; // already processed
        }

        visited[idx] = 1;

        for (char nei : graph.get(node)) {
            if (dfs(nei)) {
                return true;
            }
        }

        visited[idx] = 2;
        res.append(node);

        return false;
    }

    // Returns false if invalid prefix case is found
    private boolean process(String w1, String w2) {
        int minLen = Math.min(w1.length(), w2.length());

        for (int i = 0; i < minLen; i++) {
            char c1 = w1.charAt(i);
            char c2 = w2.charAt(i);

            if (c1 != c2) {
                graph.get(c1).add(c2);
                return true; // only first difference matters
            }
        }

        // Invalid case: "abc" before "ab"
        return w1.length() <= w2.length();
    }
}