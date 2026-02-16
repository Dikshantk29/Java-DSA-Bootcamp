public class ShortestPath {
    public static void main(String[] args) {
        String str = "WWEWWNNNNSSSWE";
        System.out.println(shortestPathCal(str));
    }

    static int shortestPathCal(String str) {
        int x = 0, y = 0;

        for (int i = 0; i < str.length(); i++) {
            char dir = str.charAt(i);

            if (dir == 'N') {
                y++;
            } else if (dir == 'S') {
                y--;
            } else if (dir == 'E') {
                x++;
            } else if (dir == 'W') {
                x--;
            }
        }

        // Calculate straight-line distance and round it to nearest integer
        return (int) Math.round(Math.sqrt(x * x + y * y));
    }
}
