public class Main {
    public static void main(String[] args) {
        Vector vec_1= new Vector(new double[]{1,2,2});
        System.out.println("1)метод, вычисляющий длину вектора.");
        vec_1.getVector();
        System.out.println(vec_1.getLen());
        System.out.println("-------------");

        System.out.println("2)метод, вычисляющий скалярное произведение.");
        Vector vec_2=new Vector(new double[]{2,2,1});
        vec_1.getVector();
        vec_2.getVector();
        System.out.println(vec_1.getScalarProduct(vec_2));
        System.out.println("-------------");

        System.out.println("3)метод, вычисляющий векторное произведение с другим вектором.");
        Vector base_i=new Vector(new double[] {1,0,0});
        Vector base_j=new Vector(new double[] {0,1,0});
        Vector base_k=base_i.getVectorProduct(base_j);
        base_i.getVector();
        base_j.getVector();
        System.out.println("VectorProduct");
        base_k.getVector();
        System.out.println("-------------");

        System.out.println("4)метод, вычисляющий угол между векторами (или косинус угла)");
        vec_1.getVector();
        vec_2.getVector();
        System.out.println("cos(a)="+vec_1.getCos(vec_2));
        System.out.println("-------------");

        System.out.println("5)cтатический метод, который принимает целое число N, и возвращает массив случайных векторов размером N.");
        Matrix rand=new Matrix(Vector.genRandomVectors(5,3));
        rand.getMatrix();
        System.out.println("-------------");

        System.out.println("1)Сложение и вычитание матриц.");
        rand=new Matrix(Vector.genRandomVectors(2,4));
        Matrix rand_2=new Matrix(Vector.genRandomVectors(2,4));
        rand.getMatrix();
        System.out.println("    ");
        rand_2.getMatrix();
        System.out.println("сумма");
        rand.getSum(rand_2).getMatrix();
        System.out.println("разность");
        rand.getSub(rand_2).getMatrix();
        System.out.println("-------------");

        System.out.println("2)Умножение матрицы на число.");
        rand = new Matrix(Vector.genRandomVectors(3,3));
        rand.getMatrix();
        double a=Math.random()*10;
        System.out.println("умножение на "+a);
        rand.scale(a).getMatrix();
        System.out.println("-------------");

        System.out.println("3)Произведение двух матриц.");
        rand = new Matrix(Vector.genRandomVectors(4,2));
        rand_2 = new Matrix(Vector.genRandomVectors(2,3));
        rand.getMatrix();
        System.out.println();
        rand_2.getMatrix();
        System.out.println("Произведение");
        rand.getMult(rand_2).getMatrix();
        System.out.println("-------------");

        System.out.println("4)Транспонированная матрица.");
        rand = new Matrix(Vector.genRandomVectors(2,3));
        rand.getMatrix();
        System.out.println("Transpose");
        rand.getTranspose().getMatrix();
        System.out.println("-------------");

        System.out.println("5)Возведение матрицы в степень.");
        rand = new Matrix(Vector.genRandomVectors(3,3));
        int exp = (int) (Math.random()*7+1);
        rand.getMatrix();
        System.out.println("Возведение в степень "+exp);
        rand.getPow(exp).getMatrix();
        System.out.println("Для наглядности:");
        Matrix L=new Matrix(new Vector[]{base_i, base_j, base_k});
        a = (int) (Math.random()*5+1);
        exp =(int) (Math.random()*7+1);
        L= L.scale(a);
        L.getMatrix();
        System.out.println("Возведение в степень "+exp);
        L.getPow(exp).getMatrix();
        System.out.println("-------------");
    }
}