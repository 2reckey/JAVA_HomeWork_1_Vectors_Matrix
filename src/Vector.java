import java.util.Arrays;

public class Vector {
    double[] x;
    int dimension;
    public Vector(double[] x){
        this.x = x;
        dimension=x.length;
    }
    public void getVector(){
        System.out.println(Arrays.toString(x));
    }
    public Vector scale(double k){
        double[] vector_scaled_cords= new double[dimension];
        for (int i=0;i<dimension;++i) {vector_scaled_cords[i]=k*x[i];}
        return new Vector(vector_scaled_cords);
    }
    public double getLen(){
        double sum_sqr=0;
        for (int i=0;i<dimension;++i) {sum_sqr+=Math.pow(x[i],2);}
        return Math.sqrt(sum_sqr);
    }
    public Vector getSum(Vector a){
        double[] vector_sum_cords= new double[dimension];
        if (a.dimension == dimension){
            for (int i=0;i<dimension;++i){vector_sum_cords[i]=x[i]+a.x[i];}
        }
        return new Vector(vector_sum_cords);
    }
    public Vector getSub(Vector a){
        return getSum(a.scale(-1));
    }

    public double getScalarProduct(Vector a){
        double scalar_product=0;
        if (a.dimension == dimension){
            for (int i=0;i<dimension;++i){scalar_product+=x[i]*a.x[i];}
        }
        return scalar_product;
    }
    public double getCos(Vector a){
        return getScalarProduct(a)/getLen()/a.getLen();
    }
    public Vector getVectorProduct(Vector a){
        double[] vector_product_cords= new double[3];
        if ((dimension==3)&&(a.dimension == dimension)){
            for (int i=0;i<3;++i){vector_product_cords[i]=x[(i+1)%3]*a.x[(i+2)%3]-x[(i+2)%3]*a.x[(i+1)%3];}
        }
        return new Vector(vector_product_cords);
    }
    public static Vector[] genRandomVectors(int n, int dim){
        Vector[] vectors_array= new Vector[n];
        for (int i=0;i<n;++i){
            double[] random_vector_cords= new double[dim];
            for (int j=0;j<dim;++j){random_vector_cords[j]=Math.random()*20-10;}
            vectors_array[i]=new Vector(random_vector_cords);
        }
        return vectors_array;
    }
}