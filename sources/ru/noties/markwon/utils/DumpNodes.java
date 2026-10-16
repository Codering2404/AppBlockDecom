package ru.noties.markwon.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import org.commonmark.node.Block;
import org.commonmark.node.Node;
import org.commonmark.node.Visitor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class DumpNodes {

    /* JADX INFO: renamed from: ru.noties.markwon.utils.DumpNodes$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class AnonymousClass1 implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Indent f147398a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ StringBuilder f147399b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ NodeProcessor f147400c;

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            Node node = (Node) objArr[0];
            this.f147398a.a(this.f147399b);
            this.f147399b.append(this.f147400c.a(node));
            if (!(node instanceof Block)) {
                this.f147399b.append('\n');
                return null;
            }
            this.f147399b.append(" [\n");
            this.f147398a.c();
            DumpNodes.b((Visitor) obj, node);
            this.f147398a.b();
            this.f147398a.a(this.f147399b);
            this.f147399b.append("]\n");
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Indent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f147401a;

        void a(StringBuilder sb) {
            for (int i3 = 0; i3 < this.f147401a; i3++) {
                sb.append(' ');
                sb.append(' ');
            }
        }

        void b() {
            this.f147401a--;
        }

        void c() {
            this.f147401a++;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface NodeProcessor {
        String a(Node node);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class NodeProcessorToString implements NodeProcessor {
        @Override // ru.noties.markwon.utils.DumpNodes.NodeProcessor
        public String a(Node node) {
            return node.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Visitor visitor, Node node) {
        Node nodeD = node.d();
        while (nodeD != null) {
            Node nodeF = nodeD.f();
            nodeD.a(visitor);
            nodeD = nodeF;
        }
    }
}
