//Exercise 17
// 17. The Java Development Kit includes a file src.zip with the source code of the Java library. Unzip and, with your favorite text search tool, find usages of the labeled break and continue sequences. Take one and rewrite it without a labeled statement.

public class Exercise17 {

    public static void main(String[] args) {

        //Found instance of labeled break
        //Found at -> jdk_source/java.desktop/java/awt/font/TextLine.java....
        System.out.println(highlightRed("\n" + "=== FOUND INSTANCE: LABELED BREAK ==="));
        System.out.println(highlightRed("// From jdk_source/java.desktop/java/awt/font/TextLine.java"));
        System.out.println(LABELED_BREAK);
        
        //Found instance of labeled continue
        System.out.println(highlightRed("=== FOUND INSTANCE: LABELED CONTINUE ==="));
        System.out.println(highlightRed("// From jdk_source/java.base/java/util/Collections.java"));
        System.out.println(LABELED_CONTINUE);

        //Take one and rewrite it without a labeled statement 
        //Modified instance of labeled continue
        System.out.println(highlightRed("=== MODIFIED INSTANCE: LABELS REMOVED ==="));
        System.out.println(highlight(LABEL_REMOVED));

        return;
    }


    private static final String ANSI_GREEN = "\033[0;32m";
    private static final String ANSI_RESET = "\033[0m";
    private static final String ANSI_RED = "\033[0;31m";

    private static String highlight(String codeText) {
        return codeText.replaceAll("(//.*)", ANSI_GREEN + "$1" + ANSI_RESET);
    }

    private static String highlightRed(String text) {
        return ANSI_RED + text + ANSI_RESET;
    }

private static final String LABELED_BREAK = """
        static Rectangle computePixelBounds(BufferedImage im) {
            int w = im.getWidth();
            int h = im.getHeight();
    
            int l = -1, t = -1, r = w, b = h;
            {
                // get top
                int[] buf = new int[w];
                loop: while (++t < h) {
                    im.getRGB(0, t, buf.length, 1, buf, 0, w); // w ignored
                    for (int i = 0; i < buf.length; i++) {
                        if (buf[i] != -1) {
                            break loop;
                        }
                    }
                }
            }
            // get bottom
            {
                int[] buf = new int[w];
                loop: while (--b > t) {
                    im.getRGB(0, b, buf.length, 1, buf, 0, w); // w ignored
                    for (int i = 0; i < buf.length; ++i) {
                        if (buf[i] != -1) {
                            break loop;
                        }
                    }
                }
                ++b;
            }
    
            // get left
            {
                loop: while (++l < r) {
                    for (int i = t; i < b; ++i) {
                        int v = im.getRGB(l, i);
                        if (v != -1) {
                            break loop;
                        }
                    }
                }
            }
    
            // get right
            {
                loop: while (--r > l) {
                    for (int i = t; i < b; ++i) {
                        int v = im.getRGB(r, i);
                        if (v != -1) {
                            break loop;
                        }
                    }
                }
                ++r;
            }
    
            return new Rectangle(l, t, r-l, b-t);
        }
        """;
        
    private static final String LABELED_CONTINUE = """
        public static int indexOfSubList(List<?> source, List<?> target) {
            int sourceSize = source.size();
            int targetSize = target.size();
            int maxCandidate = sourceSize - targetSize;
    
            if (sourceSize < INDEXOFSUBLIST_THRESHOLD ||
                (source instanceof RandomAccess&&target instanceof RandomAccess)) {
            nextCand:
                for (int candidate = 0; candidate <= maxCandidate; candidate++) {
                    for (int i=0, j=candidate; i<targetSize; i++, j++)
                        if (!eq(target.get(i), source.get(j)))
                            continue nextCand;  // Element mismatch, try next cand
                    return candidate;  // All elements of candidate matched target
                }
            } else {  // Iterator version of above algorithm
                ListIterator<?> si = source.listIterator();
            nextCand:
                for (int candidate = 0; candidate <= maxCandidate; candidate++) {
                    ListIterator<?> ti = target.listIterator();
                    for (int i=0; i<targetSize; i++) {
                        if (!eq(ti.next(), si.next())) {
                            // Back up source iterator to next candidate
                            for (int j=0; j<i; j++)
                                si.previous();
                            continue nextCand;
                        }
                    }
                    return candidate;
                }
            }
            return -1;  // No candidate matched the target
        }
        """;
        
    private static final String LABEL_REMOVED = """
        public static int indexOfSubList(List<?> source, List<?> target) {
            int sourceSize = source.size();
            int targetSize = target.size();
            int maxCandidate = sourceSize - targetSize;
    
            //1st Half
            if (sourceSize < INDEXOFSUBLIST_THRESHOLD ||
                (source instanceof RandomAccess && target instanceof RandomAccess)) {
                // Removed continue block
                for (int candidate = 0; candidate <= maxCandidate; candidate++) {
                    //nested a bool within the outer for loop
                    boolean nextCandNeeded = false; // set bool to success condition by default
                    
                    for (int i=0, j=candidate; i<targetSize; i++, j++) { //inner for loop
                        if (!eq(target.get(i), source.get(j))) {
                            nextCandNeeded = true; //change bool to ensure repetition of outer for loop
                            break; // Add non-labeled break to exit inner loop once mismatch
                        }
                    }      
                    //success case - return occurs only IF bool was not altered
                    if (nextCandNeeded == false) { 
                        return candidate;  
                    }
                }
            //2nd Half
            } else {  // Iterator version of above algorithm
                ListIterator<?> si = source.listIterator();
    
                //Removed continue block
                for (int candidate = 0; candidate <= maxCandidate; candidate++) {
                    //nested a bool within the outer for loop
                    boolean nextCandNeeded = false; // set bool to success condition by default
                    ListIterator<?> ti = target.listIterator();
    
                    for (int i=0; i<targetSize; i++) { //inner for loop
                        if (!eq(ti.next(), si.next())) { //this condition means failure
                            //do 2 things
                                // 1. adjust satellite iterator backwards for next pass
                            for (int j=0; j<i; j++){
                                si.previous();
                            }
                            // 2. adjust bool to prevent success case, and ernsure outer loop continues
                            nextCandNeeded = true;
                            break; // break from inner for loop 
                        }
                    }
                    //if bool is still false, this means success// return 
                    if(nextCandNeeded == false){
                        return candidate;
                    }
                }
            }
            return -1;  // No candidate matched the target
        }
        """;

}