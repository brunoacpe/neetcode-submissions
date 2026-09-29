class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length())
              .append("#")
              .append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();

        int i = 0;

        while (i < str.length()) {

            // Encontra o '#'
            int j = i;

            while (str.charAt(j) != '#') {
                j++;
            }

            // Tudo antes do '#' representa o tamanho
            int length = Integer.parseInt(str.substring(i, j));

            // Começo da string
            int start = j + 1;

            // Fim da string
            int end = start + length;

            res.add(str.substring(start, end));

            // Vai para o começo da próxima string
            i = end;
        }

        return res;
    }
}