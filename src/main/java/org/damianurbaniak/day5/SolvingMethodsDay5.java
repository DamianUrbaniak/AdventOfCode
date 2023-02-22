package org.damianurbaniak.day5;

import org.damianurbaniak.common.Solutions;

import java.util.List;

public class SolvingMethodsDay5 {

    public static Solutions finalResult(List<Segment> segmentsList) {
        return new Solutions(null, countOverlaps(processing(segmentsList)).toString());
    }


    public static int[][] processing(List<Segment> segmentsList) {
        int[][] diagram = new int[1000][1000];

        for (int i = 0; i < segmentsList.size(); i++) {

            coveringPosition(segmentsList.get(i), diagram);
        }
        return diagram;
    }

    //marking coordinates with corresponding segments
    private static void coveringPosition(Segment segment, int[][] diagram) {
        int xa = segment.a.x;
        int xb = segment.b.x;
        int ya = segment.a.y;
        int yb = segment.b.y;

        if (xa != xb && ya != yb) {
            int xDiff = Math.abs(xa - xb);
            int yDiff = Math.abs(ya - yb);

            if (xDiff == yDiff) {
                if (xa < xb && ya < yb) {
                    for (int i = 0; i <= xDiff; i++) {
                        diagram[xa++][ya++] += 1;
                    }
                } else if (xa > xb && ya < yb) {
                    for (int i = 0; i <= xDiff; i++) {
                        diagram[xa--][ya++] += 1;
                    }
                } else if (xa > xb && ya > yb) {
                    for (int i = 0; i <= xDiff; i++) {
                        diagram[xa--][ya--] += 1;
                    }
                } else if (xa < xb && ya > yb) {
                    for (int i = 0; i <= xDiff; i++) {
                        diagram[xa++][ya--] += 1;
                    }
                }
            } else {
                return;
            }
        } else if (xa < xb) {
            for (int i = xa; i <= xb; i++) {
                diagram[ya][i] += 1;
            }
        } else if (xa > xb) {
            for (int i = xb; i <= xa; i++) {
                diagram[ya][i] += 1;
            }
        } else if (ya > yb) {
            for (int i = yb; i <= ya; i++) {
                diagram[i][xa] += 1;
            }
        } else if (ya < yb) {
            for (int i = ya; i <= yb; i++) {
                diagram[i][xa] += 1;
            }
        }
    }

    //counting fields which were overlapped two times or more
    private static Integer countOverlaps(int[][] diagram) {
        int sum = 0;
        for (int i = 0; i < diagram.length; i++) {
            for (int j = 0; j < diagram.length; j++) {
                if (diagram[i][j] >= 2) {
                    sum += 1;
                }
            }
        }
        return sum;
    }

    record Segment(Point a, Point b) {

        @Override
        public String toString() {
            return
                    "A[" + a +
                            "] B [" + b + "]";
        }
    }

    record Point(int x, int y) {
        @Override
        public String toString() {
            return "x= " + x +
                    ", y= " + y;
        }
    }
}
