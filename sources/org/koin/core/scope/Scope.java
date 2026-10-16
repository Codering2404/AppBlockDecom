package org.koin.core.scope;

import java.util.ArrayList;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.core.Koin;
import org.koin.core.error.ClosedScopeException;
import org.koin.core.error.NoBeanDefFoundException;
import org.koin.core.instance.InstanceContext;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.core.module.KoinDslMarker;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.ext.KClassExtKt;
import org.koin.mp.KoinPlatformTools;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@KoinDslMarker
@Metadata
public final class Scope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Qualifier f146063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f146064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f146065c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Koin f146066d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ArrayList f146067e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Object f146068f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ArrayList f146069g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ArrayDeque f146070h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f146071i;

    public /* synthetic */ Scope(Qualifier qualifier, String str, boolean z2, Koin koin, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(qualifier, str, (i3 & 4) != 0 ? false : z2, koin);
    }

    private final Object d(KClass kClass, Qualifier qualifier, Function0 function0) {
        ArrayList arrayList = this.f146067e;
        int size = arrayList.size();
        Object objI = null;
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            objI = ((Scope) obj).i(kClass, qualifier, function0);
            if (objI != null) {
                break;
            }
        }
        return objI;
    }

    public static /* synthetic */ Object j(Scope scope, KClass kClass, Qualifier qualifier, Function0 function0, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            qualifier = null;
        }
        if ((i3 & 4) != 0) {
            function0 = null;
        }
        return scope.i(kClass, qualifier, function0);
    }

    private final Object q(Qualifier qualifier, KClass kClass, Function0 function0) throws ClosedScopeException, NoBeanDefFoundException {
        if (this.f146071i) {
            throw new ClosedScopeException("Scope '" + this.f146064b + "' is closed");
        }
        final ParametersHolder parametersHolder = function0 != null ? (ParametersHolder) function0.invoke() : null;
        if (parametersHolder != null) {
            Logger loggerF = this.f146066d.f();
            Level level = Level.DEBUG;
            if (loggerF.c(level)) {
                loggerF.a(level, "| >> parameters " + parametersHolder + ' ');
            }
            KoinPlatformTools.f146106a.h(this, new Function0<Unit>() { // from class: org.koin.core.scope.Scope$resolveInstance$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m2209invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m2209invoke() {
                    this.f146085a.m().addFirst(parametersHolder);
                }
            });
        }
        Object objR = r(qualifier, kClass, new InstanceContext(this.f146066d.f(), this, parametersHolder), function0);
        if (parametersHolder != null) {
            Logger loggerF2 = this.f146066d.f();
            Level level2 = Level.DEBUG;
            if (loggerF2.c(level2)) {
                loggerF2.a(level2, "| << parameters");
            }
            KoinPlatformTools.f146106a.h(this, new Function0<ParametersHolder>() { // from class: org.koin.core.scope.Scope$resolveInstance$3
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final ParametersHolder invoke() {
                    return (ParametersHolder) this.f146087a.m().removeFirstOrNull();
                }
            });
        }
        return objR;
    }

    private final Object r(Qualifier qualifier, KClass kClass, InstanceContext instanceContext, Function0 function0) throws NoBeanDefFoundException {
        Object obj;
        Object objI = this.f146066d.e().i(qualifier, kClass, this.f146063a, instanceContext);
        if (objI == null) {
            Logger loggerF = this.f146066d.f();
            String str = "|- ? t:'" + KClassExtKt.a(kClass) + "' - q:'" + qualifier + "' look in injected parameters";
            Level level = Level.DEBUG;
            if (loggerF.c(level)) {
                loggerF.a(level, str);
            }
            ParametersHolder parametersHolder = (ParametersHolder) this.f146070h.firstOrNull();
            Object obj2 = null;
            objI = parametersHolder != null ? parametersHolder.c(kClass) : null;
            if (objI == null) {
                Logger loggerF2 = this.f146066d.f();
                String str2 = "|- ? t:'" + KClassExtKt.a(kClass) + "' - q:'" + qualifier + "' look at scope source";
                if (loggerF2.c(level)) {
                    loggerF2.a(level, str2);
                }
                Object obj3 = this.f146068f;
                if (obj3 != null && Intrinsics.areEqual(Reflection.b(obj3.getClass()), kClass) && qualifier == null && (obj = this.f146068f) != null) {
                    obj2 = obj;
                }
                if (obj2 != null) {
                    return obj2;
                }
                Logger loggerF3 = this.f146066d.f();
                String str3 = "|- ? t:'" + KClassExtKt.a(kClass) + "' - q:'" + qualifier + "' look in other scopes";
                if (loggerF3.c(level)) {
                    loggerF3.a(level, str3);
                }
                Object objD = d(kClass, qualifier, function0);
                if (objD != null) {
                    return objD;
                }
                KoinPlatformTools.f146106a.h(this, new Function0<Unit>() { // from class: org.koin.core.scope.Scope$resolveValue$4$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2210invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m2210invoke() {
                        this.f146088a.m().clear();
                    }
                });
                Logger loggerF4 = this.f146066d.f();
                if (loggerF4.c(level)) {
                    loggerF4.a(level, "|- << parameters");
                }
                t(qualifier, kClass);
                throw new KotlinNothingValueException();
            }
        }
        return objI;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.Void t(org.koin.core.qualifier.Qualifier r4, kotlin.reflect.KClass r5) throws org.koin.core.error.NoBeanDefFoundException {
        /*
            r3 = this;
            if (r4 == 0) goto L1a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = " & qualifier:'"
            r0.append(r1)
            r0.append(r4)
            r4 = 39
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            if (r4 != 0) goto L1c
        L1a:
            java.lang.String r4 = ""
        L1c:
            org.koin.core.error.NoBeanDefFoundException r0 = new org.koin.core.error.NoBeanDefFoundException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "No definition found for class:'"
            r1.append(r2)
            java.lang.String r5 = org.koin.ext.KClassExtKt.a(r5)
            r1.append(r5)
            java.lang.String r5 = "' q:'"
            r1.append(r5)
            r1.append(r4)
            java.lang.String r4 = "'. Check your definitions!"
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.koin.core.scope.Scope.t(org.koin.core.qualifier.Qualifier, kotlin.reflect.KClass):java.lang.Void");
    }

    public final void c() {
        KoinPlatformTools.f146106a.h(this, new Function0<Unit>() { // from class: org.koin.core.scope.Scope$close$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m2207invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m2207invoke() {
                Logger loggerF = this.f146072a.l().f();
                String str = "|- (-) Scope - id:'" + this.f146072a.g() + '\'';
                Level level = Level.DEBUG;
                if (loggerF.c(level)) {
                    loggerF.a(level, str);
                }
                ArrayList arrayList = this.f146072a.f146069g;
                Scope scope = this.f146072a;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    ((ScopeCallback) obj).a(scope);
                }
                this.f146072a.f146069g.clear();
                this.f146072a.s(null);
                this.f146072a.f146071i = true;
                this.f146072a.l().j().c(this.f146072a);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(kotlin.reflect.KClass r9, org.koin.core.qualifier.Qualifier r10, kotlin.jvm.functions.Function0 r11) throws org.koin.core.error.ClosedScopeException, org.koin.core.error.NoBeanDefFoundException {
        /*
            r8 = this;
            java.lang.String r0 = "clazz"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            org.koin.core.Koin r0 = r8.f146066d
            org.koin.core.logger.Logger r0 = r0.f()
            org.koin.core.logger.Level r1 = org.koin.core.logger.Level.DEBUG
            boolean r0 = r0.c(r1)
            if (r0 == 0) goto L98
            r0 = 39
            if (r10 == 0) goto L2d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = " with qualifier '"
            r2.append(r3)
            r2.append(r10)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            if (r2 != 0) goto L2f
        L2d:
            java.lang.String r2 = ""
        L2f:
            org.koin.core.Koin r3 = r8.f146066d
            org.koin.core.logger.Logger r3 = r3.f()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "|- '"
            r4.append(r5)
            java.lang.String r6 = org.koin.ext.KClassExtKt.a(r9)
            r4.append(r6)
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = " ..."
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r3.a(r1, r0)
            org.koin.mp.KoinPlatformTimeTools r0 = org.koin.mp.KoinPlatformTimeTools.f146105a
            long r2 = r0.a()
            java.lang.Object r10 = r8.q(r10, r9, r11)
            long r6 = r0.a()
            long r6 = r6 - r2
            double r2 = (double) r6
            r6 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r2 = r2 / r6
            org.koin.core.Koin r11 = r8.f146066d
            org.koin.core.logger.Logger r11 = r11.f()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            java.lang.String r9 = org.koin.ext.KClassExtKt.a(r9)
            r0.append(r9)
            java.lang.String r9 = "' in "
            r0.append(r9)
            r0.append(r2)
            java.lang.String r9 = " ms"
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            r11.a(r1, r9)
            return r10
        L98:
            java.lang.Object r9 = r8.q(r10, r9, r11)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.koin.core.scope.Scope.e(kotlin.reflect.KClass, org.koin.core.qualifier.Qualifier, kotlin.jvm.functions.Function0):java.lang.Object");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        Scope scope = (Scope) obj;
        return Intrinsics.areEqual(this.f146063a, scope.f146063a) && Intrinsics.areEqual(this.f146064b, scope.f146064b) && this.f146065c == scope.f146065c && Intrinsics.areEqual(this.f146066d, scope.f146066d);
    }

    public final boolean f() {
        return this.f146071i;
    }

    public final String g() {
        return this.f146064b;
    }

    public final Logger h() {
        return this.f146066d.f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int iHashCode = ((this.f146063a.hashCode() * 31) + this.f146064b.hashCode()) * 31;
        boolean z2 = this.f146065c;
        ?? r12 = z2;
        if (z2) {
            r12 = 1;
        }
        return ((iHashCode + r12) * 31) + this.f146066d.hashCode();
    }

    public final Object i(KClass clazz, Qualifier qualifier, Function0 function0) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        try {
            return e(clazz, qualifier, function0);
        } catch (ClosedScopeException unused) {
            Logger loggerF = this.f146066d.f();
            String str = "* Scope closed - no instance found for " + KClassExtKt.a(clazz) + " on scope " + this;
            Level level = Level.DEBUG;
            if (!loggerF.c(level)) {
                return null;
            }
            loggerF.a(level, str);
            return null;
        } catch (NoBeanDefFoundException unused2) {
            Logger loggerF2 = this.f146066d.f();
            String str2 = "* No instance found for " + KClassExtKt.a(clazz) + " on scope " + this;
            Level level2 = Level.DEBUG;
            if (!loggerF2.c(level2)) {
                return null;
            }
            loggerF2.a(level2, str2);
            return null;
        }
    }

    public final Qualifier k() {
        return this.f146063a;
    }

    public final Koin l() {
        return this.f146066d;
    }

    public final ArrayDeque m() {
        return this.f146070h;
    }

    public final boolean n() {
        return !f();
    }

    public final void o(Scope... scopes) {
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        if (this.f146065c) {
            throw new IllegalStateException("Can't add scope link to a root scope");
        }
        CollectionsKt.addAll(this.f146067e, scopes);
    }

    public final void p(ScopeCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f146069g.add(callback);
    }

    public final void s(Object obj) {
        this.f146068f = obj;
    }

    public String toString() {
        return "['" + this.f146064b + "']";
    }

    public Scope(Qualifier scopeQualifier, String id, boolean z2, Koin _koin) {
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(_koin, "_koin");
        this.f146063a = scopeQualifier;
        this.f146064b = id;
        this.f146065c = z2;
        this.f146066d = _koin;
        this.f146067e = new ArrayList();
        this.f146069g = new ArrayList();
        this.f146070h = new ArrayDeque();
    }
}
