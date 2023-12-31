package org.example.lab3;

import java.util.function.Function;

/**
 * Hello world!
 *
 */
public class App {
    public static void printEvenNumbers(int from, int to) {
        System.out.printf("Printing even numbers in the range [%d,%d]\n", from, to);
        for (int i = from; i <= to; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    public static void printNumbersDivisibleByThree(int from, int to) {
        System.out.printf("Printing numbers divisible by 3 in the range [%d,%d]\n", from, to);
        for (int i = from; i <= to; i++) {
            if (i % 3 == 0) {
                System.out.println(i);
            }
        }
    }

    static class IsEven implements Function<Integer, Boolean> {
        @Override
        public Boolean apply(Integer x) {
            return x % 2 == 0;
        }
    }

    static class IsDivisibleByThree implements Function<Integer, Boolean> {
        @Override
        public Boolean apply(Integer x) {
            return x % 3 == 0;
        }
    }

    public static void printNumbers(int from, int to, Function<Integer, Boolean> filter) {
        System.out.printf("Printing numbers in the range [%d,%d]\n", from, to);
        for (int i = from; i <= to; i++) {
            if (filter.apply(i)) {
                System.out.println(i);
            }
        }
    }

//    public static void main(String[] args) {
//        if (args.length < 3) {
//            System.out.println("Error: At least three parameters expected, from, to, and base.");
//            System.exit(1);
//        }
//
//        int from = Integer.parseInt(args[0]);
//        int to = Integer.parseInt(args[1]);
//        int base = Integer.parseInt(args[2]);
//
////        if (base == 2) {
////            printEvenNumbers(from, to);
////        } else if (base == 3) {
////            printNumbersDivisibleByThree(from, to);
////        } else {
////            System.out.println("Error: Invalid base. Base should be either 2 or 3.");
////        }
//
//        Function<Integer, Boolean> filter;
////        if (base == 2) {
////            filter = new IsEven();
//////            printEvenNumbers(from, to);
////        } else if (base == 3) {
////            filter = new IsDivisibleByThree();
//////            printNumbersDivisibleByThree(from, to);
////
////        } else {
////            System.out.println("Error: Invalid base. Base should be either 2 or 3.");
////            return;
////        }
////        test >> part 3
//        if (base == 2) {
//            filter = new IsEven();
//        } else if (base == 3) {
//            filter = new IsDivisibleByThree();
//        } else if (base == 5) {
//            filter = x -> x % 5 == 0; // Lambda expression for divisibility by 5
//        } else if (base == 10) {
//            filter = x -> x % 10 == 0; // Lambda expression for divisibility by 10
//        } else {
//            System.out.println("Error: Invalid base. Base should be 2, 3, 5, or 10.");
//            return;
//        }
//
//        printNumbers(from, to, filter);
//    }\

////    part IV
//public static void main(String[] args) {
//    if (args.length < 3) {
//        System.out.println("Error: At least three parameters expected, from, to, and base.");
//        System.exit(1);
//    }
//
//    int from = Integer.parseInt(args[0]);
//    int to = Integer.parseInt(args[1]);
//    int base = Integer.parseInt(args[2]);
//
//    Function<Integer, Boolean> divisibleByBase = x -> x % base == 0;
//
//    printNumbers(from, to, divisibleByBase);
//}

//    part v
//@SafeVarargs
//public static Function<Integer, Boolean> combineWithAnd(Function<Integer, Boolean>... filters) {
//    return x -> {
//        for (Function<Integer, Boolean> filter : filters) {
//            if (!filter.apply(x)) {
//                return false;
//            }
//        }
//        return true;
//    };
//}
//
//    @SafeVarargs
//    public static Function<Integer, Boolean> combineWithOr(Function<Integer, Boolean>... filters) {
//        return x -> {
//            for (Function<Integer, Boolean> filter : filters) {
//                if (filter.apply(x)) {
//                    return true;
//                }
//            }
//            return false;
//        };
//    }
//
//    public static void main(String[] args) {
//        if (args.length < 3) {
//            System.out.println("Error: At least three parameters expected, from, to, and base.");
//            System.exit(1);
//        }
//
//        int from = Integer.parseInt(args[0]);
//        int to = Integer.parseInt(args[1]);
//
//        String[] baseStr = args[2].split("[,v]");
//        int[] bases = new int[baseStr.length];
//
//        for (int i = 0; i < baseStr.length; i++) {
//            bases[i] = Integer.parseInt(baseStr[i]);
//        }
//
//        Function<Integer, Boolean>[] filters = new Function[bases.length];
//
//        for (int i = 0; i < bases.length; i++) {
//            int base = bases[i];
//            filters[i] = x -> x % base == 0;
//        }
//
//        Function<Integer, Boolean> filter;
//
//        if (args[2].contains(",")) {
//            filter = combineWithAnd(filters);
//        } else if (args[2].contains("v")) {
//            filter = combineWithOr(filters);
//        } else {
//            System.out.println("Error: Invalid separator. Use ',' for 'and' and 'v' for 'or'.");
//            return;
//        }
//
//        printNumbers(from, to, filter);
//    }
public static Function<Integer, Boolean> combineWithAnd(Function<Integer, Boolean>... filters) {
    return x -> {
        for (Function<Integer, Boolean> filter : filters) {
            if (!filter.apply(x)) {
                return false;
            }
        }
        return true;
    };
}

    public static Function<Integer, Boolean> combineWithOr(Function<Integer, Boolean>... filters) {
        return x -> {
            for (Function<Integer, Boolean> filter : filters) {
                if (filter.apply(x)) {
                    return true;
                }
            }
            return false;
        };
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Error: At least three parameters expected, from, to, and base.");
            System.exit(1);
        }

        int from = Integer.parseInt(args[0]);
        int to = Integer.parseInt(args[1]);

        String[] baseStr = args[2].split("[,v]");
        int[] bases = new int[baseStr.length];

        for (int i = 0; i < baseStr.length; i++) {
            bases[i] = Integer.parseInt(baseStr[i]);
        }

        Function<Integer, Boolean>[] filters = new Function[bases.length];

        for (int i = 0; i < bases.length; i++) {
            int base = bases[i];
            filters[i] = x -> x % base == 0;
        }

        Function<Integer, Boolean> filter;

        if (args[2].contains(",")) {
            filter = combineWithAnd(filters);
        } else if (args[2].contains("v")) {
            filter = combineWithOr(filters);
        } else {
            filter = filters[0]; // Use the filter for the single base
        }

        printNumbers(from, to, filter);
    }
}
