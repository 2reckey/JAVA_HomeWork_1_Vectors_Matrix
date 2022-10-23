public class Matrix {
    Vector[] vectors;
    int x_dim;
    int y_dim;
    public Matrix(Vector[] vectors){
        this.vectors=vectors;
        y_dim=vectors.length;
        x_dim=vectors[0].dimension;
    }
    public void getMatrix(){
        for (int i=0;i<y_dim;++i){vectors[i].getVector();}
    }
    public Matrix scale(double k){
        Vector[] matrix_scaled_vectors=new Vector[y_dim];
        for (int i=0;i<y_dim;++i) {matrix_scaled_vectors[i]=vectors[i].scale(k);}
        return new Matrix(matrix_scaled_vectors);
    }
    public Matrix getSum(Matrix a){
        Vector[] matrix_sum_vectors=new Vector[y_dim];
        if ((x_dim==a.x_dim)&&(y_dim==a.y_dim)){
            for (int i=0;i<y_dim;++i) {matrix_sum_vectors[i]=vectors[i].getSum(a.vectors[i]);}
        }
        return new Matrix(matrix_sum_vectors);
    }
    public Matrix getSub(Matrix a) {
        return getSum(a.scale(-1));
    }
    public Matrix getTranspose(){
        Vector[] matrix_transpose_vectors=new Vector[x_dim];
        for (int i=0;i<x_dim;++i){
            double[] vector_transpose_cords=new double[y_dim];
            for (int j=0;j<y_dim;++j){vector_transpose_cords[j]=vectors[j].x[i];}
            matrix_transpose_vectors[i]=new Vector(vector_transpose_cords);
        }
        return new Matrix(matrix_transpose_vectors);
    }
    public Matrix getMult(Matrix a){
        Vector[] matrix_mult_vectors=new Vector[y_dim];
        if ((x_dim==a.y_dim)){
            Matrix a_tr=a.getTranspose();
            for (int i=0;i<y_dim;++i) {
                double[] vector_mult_cords = new double[a.x_dim];
                for (int j = 0; j < a.x_dim; ++j) {
                    vector_mult_cords[j] = vectors[i].getScalarProduct(a_tr.vectors[j]);
                }
                matrix_mult_vectors[i] = new Vector(vector_mult_cords);
            }
        }
        return new Matrix(matrix_mult_vectors);
    }
    public Matrix getPow(int exp){
        Matrix result_matrix = this;
        if (exp>1){
            exp-=1;
            Matrix exp_matrix = result_matrix;
            while(exp > 0){
                if(exp % 2 == 1){
                    result_matrix= result_matrix.getMult(exp_matrix);
                }
                exp_matrix= exp_matrix.getMult(exp_matrix);
                exp >>= 1;
            }
        }
        return result_matrix;
    }
}