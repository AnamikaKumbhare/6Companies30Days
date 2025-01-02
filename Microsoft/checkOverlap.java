class Solution {
    public boolean checkOverlap(int radius, int xCentre, int yCentre, int x1, int y1, int x2, int y2) {
        int d_x1=xCentre-x1;
        int d_x2=xCentre-x2;
        int d_y1=yCentre-y1;
        int d_y2=yCentre-y2;
        int square=radius*radius;
        int x_top=xCentre+radius;
        int x_bottom=xCentre-radius;
        int y_top=yCentre+radius;
        int y_bottom=yCentre-radius;
        boolean insideX=(xCentre>=x1) && (xCentre<=x2);
        boolean insideY=(yCentre>=y1) && (yCentre<=y2);

        if ((d_x1 * d_x1 + d_y1 * d_y1 <= square) || (d_x2 * d_x2 + d_y1 * d_y1 <= square) || (d_x1 * d_x1 + d_y2 * d_y2 <= square) || (d_x2 * d_x2 + d_y2 * d_y2 <= square)) {
            return true;
        }
        if (((square - d_x1 * d_x1 >= 0) && insideY) || ((square - d_x2 * d_x2 >= 0) && insideY) || ((square - d_y1 * d_y1 >= 0) && insideX) || ((square - d_y2 * d_y2 >= 0) && insideX)) {
            return true;
        }
        if ((x_top <= x2) && (x_bottom >= x1) && (y2 >= y_top) && (y1 <= y_bottom)) return true;
        return false;
    }
}