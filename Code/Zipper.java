public class Zipper {
    public static void main(String[] args) {
        // read source data
        String source = "A".repeat(180) + "1".repeat(30) + "C".repeat(50);
        System.out.println("Source text:   " + source);

        // processing
        String zipped = zip(source);
        // display results
        System.out.println("Zipped text:   " + zipped);

        // processing
        String unzipped = unzip(zipped);
        // display results
        System.out.println("Unzipped text: " + unzipped);
    }

    private static String zip(String source) {
        StringBuilder result = new StringBuilder();
        int count = 1;
        char prev = source.charAt(0);
        for (int j = 1; j < source.length(); j++) {
            if (prev == source.charAt(j)) {
                count++;
                if (j == source.length() - 1) {
                    result.append(prev).append(count);
                }
            } else {
                result.append(prev).append(count).append(" ");
                prev = source.charAt(j);
                count = 1;
            }
        }
        return result.toString();
    }

    private static String unzip(String zipped) {
        StringBuilder result = new StringBuilder();
        StringBuilder number = new StringBuilder();
        char prev = zipped.charAt(0);
        for (int i = 1; i < zipped.length(); i++) {
            char c = zipped.charAt(i);
            if (c >= '0' && c <= '9') {
                number.append(c);
                if (i == zipped.length() - 1) {
                    result.append(String.valueOf(prev).repeat(Integer.parseInt(number.toString())));
                }
            } else {
                result.append(String.valueOf(prev).repeat(Integer.parseInt(number.toString())));
                prev = zipped.charAt(++i);
                number.setLength(0);
            }
        }
        return result.toString();
    }
}
