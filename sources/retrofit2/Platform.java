package retrofit2;

import java.util.concurrent.Executor;
import retrofit2.BuiltInFactories;
import retrofit2.Reflection;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
final class Platform {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Executor f146935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Reflection f146936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final BuiltInFactories f146937c;

    static {
        String property = System.getProperty("java.vm.name");
        property.getClass();
        if (property.equals("RoboVM")) {
            f146935a = null;
            f146936b = new Reflection();
            f146937c = new BuiltInFactories();
        } else if (property.equals("Dalvik")) {
            f146935a = new AndroidMainExecutor();
            f146936b = new Reflection.Android24();
            f146937c = new BuiltInFactories.Java8();
        } else {
            f146935a = null;
            f146936b = new Reflection.Java8();
            f146937c = new BuiltInFactories.Java8();
        }
    }
}
