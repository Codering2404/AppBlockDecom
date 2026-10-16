package androidx.webkit.internal;

import androidx.webkit.ScriptHandler;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.ScriptHandlerBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class ScriptHandlerImpl implements ScriptHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ScriptHandlerBoundaryInterface f53932a;

    private ScriptHandlerImpl(ScriptHandlerBoundaryInterface scriptHandlerBoundaryInterface) {
        this.f53932a = scriptHandlerBoundaryInterface;
    }

    public static ScriptHandlerImpl a(InvocationHandler invocationHandler) {
        return new ScriptHandlerImpl((ScriptHandlerBoundaryInterface) BoundaryInterfaceReflectionUtil.a(ScriptHandlerBoundaryInterface.class, invocationHandler));
    }
}
