import com.microsoft.z3.*;

public class SMTVerification {
    public static void main(String[] args) {
        // Create a solver and context
        Context ctx = new Context();
        Solver solver = ctx.mkSolver();

        // Define some logical variables
        BoolExpr x = ctx.mkBoolConst("x");
        BoolExpr y = ctx.mkBoolConst("y");

        // Add a logical formula to the solver
        solver.add(ctx.mkAnd(x, y));
        //Add a logical formula to the solver
//        solver.add(ctx.mkOr(x, y));

        //Add a logical formula to the solver
        solver.add(ctx.mkNot(x));

        // Check if the formula is satisfiable
        Status status = solver.check();
        System.out.println("Status: " + status);

        // If the formula is satisfiable, print the model
        if (status == Status.SATISFIABLE) {
            Model model = solver.getModel();
            System.out.println("Model: " + model);
        }
    }


/*        // Check if the formulas are satisfiable
        if (solver.check() == Status.SATISFIABLE) {
            // Get a model (i.e., a solution) that satisfies the formulas
            Model model = solver.getModel();

            // Print the value of the variables in the model
            System.out.println("x = " + model.evaluate(x, false));
            System.out.println("y = " + model.evaluate(y, false));
        } else {
            System.out.println("Unsatisfiable");
        }
    }*/
}
