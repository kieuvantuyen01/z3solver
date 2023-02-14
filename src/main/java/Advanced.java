import com.microsoft.z3.*;

public class Advanced {
    public static void main(String[] args) throws Z3Exception {
        int[][] w = new int[][]{{1, 1}, {2, 1}, {2, 2}, {3, 2}, {4, 2}, {5, 2}, {5, 1}, {5, 3}};
        int[][] r = new int[][]{{1, 1}, {1, 3}, {2, 1}, {2, 3}, {3, 1}, {3, 3}, {4, 1}, {4, 3}};

// Create solver
        Context ctx = new Context();

// Create variables for each wire
        IntExpr[] xw = new IntExpr[w.length];
        IntExpr[] yw = new IntExpr[w.length];
        for (int i = 0; i < w.length; i++) {
            xw[i] = ctx.mkIntConst("xw_" + w[i][0] + "_" + w[i][1]);
            yw[i] = ctx.mkIntConst("yw_" + w[i][0] + "_" + w[i][1]);
        }

// Create variables for each resistor
        IntExpr[] xr = new IntExpr[r.length];
        IntExpr[] yr = new IntExpr[r.length];
        for (int i = 0; i < r.length; i++) {
            xr[i] = ctx.mkIntConst("xr_" + r[i][0] + "_" + r[i][1]);
            yr[i] = ctx.mkIntConst("yr_" + r[i][0] + "_" + r[i][1]);
        }

// Create constraints for each wire
        BoolExpr[] wireConstraints = new BoolExpr[w.length];
        for (int i = 0; i < w.length; i++) {
            wireConstraints[i] = ctx.mkAnd(
                    ctx.mkEq(xw[i], ctx.mkInt(w[i][0])),
                    ctx.mkEq(yw[i], ctx.mkInt(w[i][1]))
            );
        }

// Create constraints for each resistor
        BoolExpr[] resistorConstraints = new BoolExpr[r.length];
        for (int i = 0; i < r.length; i++) {
            IntExpr xrExpr = xr[i];
            IntExpr yrExpr = yr[i];
            BoolExpr[] orClauses = new BoolExpr[w.length];
            for (int j = 0; j < w.length; j++) {
                orClauses[j] = ctx.mkAnd(
                        ctx.mkEq(xrExpr, xw[j]),
                        ctx.mkEq(yrExpr, yw[j])
                );
            }
            resistorConstraints[i] = ctx.mkOr(orClauses);
        }

// Add constraints to solver
        Solver solver = ctx.mkSolver();
        solver.add(ctx.mkAnd(wireConstraints));
        solver.add(ctx.mkAnd(resistorConstraints));
        solver.add(ctx.mkAnd(
                ctx.mkEq(xr[0], ctx.mkInt(3)),
                ctx.mkEq(yr[0], ctx.mkInt(3))
        ));

// Check for solution
        if (solver.check() == Status.SATISFIABLE) {
            Model model = solver.getModel();
            for (int i = 0; i < r.length; i++) {
                System.out.println("xr_" + r[i][0] +
                        "_" + r[i][1] + " = " + model.evaluate(xr[i], false));
            }
        } else {
            System.out.println("Unsatisfiable");
        }
    }
}
