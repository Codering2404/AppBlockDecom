package androidx.constraintlayout.core;

import androidx.constraintlayout.core.Pools;
import com.sun.jna.Function;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class Cache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Pools.Pool f31163a = new Pools.SimplePool(Function.MAX_NARGS);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Pools.Pool f31164b = new Pools.SimplePool(Function.MAX_NARGS);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Pools.Pool f31165c = new Pools.SimplePool(Function.MAX_NARGS);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    SolverVariable[] f31166d = new SolverVariable[32];
}
