import com.microsoft.z3.*;

public class Test {
    public static void main(String[] args) throws Z3Exception {
        // Khởi tạo môi trường Z3
        Context ctx = new Context();
        Solver solver = ctx.mkSolver();

        // Tạo biến `x` và gán giá trị ban đầu cho nó là 0
        IntExpr x = ctx.mkIntConst("x");
        solver.add(ctx.mkEq(x, ctx.mkInt(0)));

        // Tạo biến `y` và gán giá trị ban đầu cho nó là false
        BoolExpr y = ctx.mkBoolConst("y");
        solver.add(ctx.mkEq(y, ctx.mkFalse()));

        // Tạo hai ràng buộc với từng hàm `t1` và `t2`
        // Hàm t1: x++, nếu x > 1 thì x--
        solver.add(ctx.mkOr(
                ctx.mkAnd(
                        ctx.mkEq(x, ctx.mkInt(0)),
                        ctx.mkEq(x, ctx.mkAdd(x, ctx.mkInt(1)))
                ),
                ctx.mkAnd(
                        ctx.mkGt(x, ctx.mkInt(1)),
                        ctx.mkEq(x, ctx.mkSub(x, ctx.mkInt(1)))
                )
        ));

        // Hàm t2: x++, y = (x > 1), nếu y thì x--
        solver.add(ctx.mkOr(
                ctx.mkAnd(
                        ctx.mkEq(x, ctx.mkInt(0)),
                        ctx.mkEq(x, ctx.mkAdd(x, ctx.mkInt(1))),
                        ctx.mkEq(y, ctx.mkFalse())
                ),
                ctx.mkAnd(
                        ctx.mkGt(x, ctx.mkInt(1)),
                        ctx.mkEq(y, ctx.mkTrue()),
                        ctx.mkEq(x, ctx.mkSub(x, ctx.mkInt(1)))
                )
        ));

        solver.add(ctx.mkEq(x, ctx.mkInt(0)));

        // Kiểm tra xem ràng buộc có đúng hay không
        Status status = solver.check();
        if (status == Status.SATISFIABLE) {
            System.out.println("Ràng buộc hợp lệ.");
            System.out.println("x = " + solver.getModel().eval(x, false));
            System.out.println("y = " + solver.getModel().eval(y, false));
        } else {
            System.out.println("Unsatisfiable");
        }
    }
}