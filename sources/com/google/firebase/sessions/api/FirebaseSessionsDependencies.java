package com.google.firebase.sessions.api;

import android.util.Log;
import com.google.firebase.sessions.api.SessionSubscriber;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class FirebaseSessionsDependencies {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FirebaseSessionsDependencies f90125a = new FirebaseSessionsDependencies();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map f90126b = Collections.synchronizedMap(new LinkedHashMap());

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Dependency {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Mutex f90127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private SessionSubscriber f90128b;

        public Dependency(Mutex mutex, SessionSubscriber sessionSubscriber) {
            Intrinsics.checkNotNullParameter(mutex, "mutex");
            this.f90127a = mutex;
            this.f90128b = sessionSubscriber;
        }

        public final Mutex a() {
            return this.f90127a;
        }

        public final SessionSubscriber b() {
            return this.f90128b;
        }

        public final void c(SessionSubscriber sessionSubscriber) {
            this.f90128b = sessionSubscriber;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Dependency)) {
                return false;
            }
            Dependency dependency = (Dependency) obj;
            return Intrinsics.areEqual(this.f90127a, dependency.f90127a) && Intrinsics.areEqual(this.f90128b, dependency.f90128b);
        }

        public int hashCode() {
            int iHashCode = this.f90127a.hashCode() * 31;
            SessionSubscriber sessionSubscriber = this.f90128b;
            return iHashCode + (sessionSubscriber == null ? 0 : sessionSubscriber.hashCode());
        }

        public String toString() {
            return "Dependency(mutex=" + this.f90127a + ", subscriber=" + this.f90128b + ')';
        }

        public /* synthetic */ Dependency(Mutex mutex, SessionSubscriber sessionSubscriber, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(mutex, (i3 & 2) != 0 ? null : sessionSubscriber);
        }
    }

    private FirebaseSessionsDependencies() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(SessionSubscriber.Name subscriberName) {
        Intrinsics.checkNotNullParameter(subscriberName, "subscriberName");
        Map dependencies = f90126b;
        if (dependencies.containsKey(subscriberName)) {
            Log.d("FirebaseSessions", "Dependency " + subscriberName + " already added.");
            return;
        }
        Intrinsics.checkNotNullExpressionValue(dependencies, "dependencies");
        dependencies.put(subscriberName, new Dependency(MutexKt.a(true), null, 2, 0 == true ? 1 : 0));
        Log.d("FirebaseSessions", "Dependency to " + subscriberName + " added.");
    }

    private final Dependency b(SessionSubscriber.Name name) {
        Map dependencies = f90126b;
        Intrinsics.checkNotNullExpressionValue(dependencies, "dependencies");
        Object obj = dependencies.get(name);
        if (obj != null) {
            Intrinsics.checkNotNullExpressionValue(obj, "getOrElse(...)");
            return (Dependency) obj;
        }
        throw new IllegalStateException("Cannot get dependency " + name + ". Dependencies should be added at class load time.");
    }

    public static final void e(SessionSubscriber subscriber) {
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        SessionSubscriber.Name nameB = subscriber.b();
        Dependency dependencyB = f90125a.b(nameB);
        if (dependencyB.b() != null) {
            Log.d("FirebaseSessions", "Subscriber " + nameB + " already registered.");
            return;
        }
        dependencyB.c(subscriber);
        Log.d("FirebaseSessions", "Subscriber " + nameB + " registered.");
        Mutex.DefaultImpls.c(dependencyB.a(), null, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00a1 -> B:27:0x00a2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(kotlin.coroutines.Continuation r11) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.google.firebase.sessions.api.FirebaseSessionsDependencies$getRegisteredSubscribers$1
            if (r0 == 0) goto L13
            r0 = r11
            com.google.firebase.sessions.api.FirebaseSessionsDependencies$getRegisteredSubscribers$1 r0 = (com.google.firebase.sessions.api.FirebaseSessionsDependencies$getRegisteredSubscribers$1) r0
            int r1 = r0.f90137j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f90137j = r1
            goto L18
        L13:
            com.google.firebase.sessions.api.FirebaseSessionsDependencies$getRegisteredSubscribers$1 r0 = new com.google.firebase.sessions.api.FirebaseSessionsDependencies$getRegisteredSubscribers$1
            r0.<init>(r10, r11)
        L18:
            java.lang.Object r11 = r0.f90135h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f90137j
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L48
            if (r2 != r3) goto L40
            java.lang.Object r2 = r0.f90134g
            java.lang.Object r5 = r0.f90133f
            java.util.Map r5 = (java.util.Map) r5
            java.lang.Object r6 = r0.f90132d
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            java.lang.Object r7 = r0.f90131c
            com.google.firebase.sessions.api.SessionSubscriber$Name r7 = (com.google.firebase.sessions.api.SessionSubscriber.Name) r7
            java.lang.Object r8 = r0.f90130b
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r0.f90129a
            java.util.Map r9 = (java.util.Map) r9
            kotlin.ResultKt.b(r11)
            goto La2
        L40:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L48:
            kotlin.ResultKt.b(r11)
            java.util.Map r11 = com.google.firebase.sessions.api.FirebaseSessionsDependencies.f90126b
            java.lang.String r2 = "dependencies"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r2)
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            int r5 = r11.size()
            int r5 = kotlin.collections.MapsKt.mapCapacity(r5)
            r2.<init>(r5)
            java.util.Set r11 = r11.entrySet()
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.Iterator r11 = r11.iterator()
            r8 = r11
            r5 = r2
        L6b:
            boolean r11 = r8.hasNext()
            if (r11 == 0) goto Lb5
            java.lang.Object r11 = r8.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            java.lang.Object r2 = r11.getKey()
            java.lang.Object r6 = r11.getKey()
            r7 = r6
            com.google.firebase.sessions.api.SessionSubscriber$Name r7 = (com.google.firebase.sessions.api.SessionSubscriber.Name) r7
            java.lang.Object r11 = r11.getValue()
            com.google.firebase.sessions.api.FirebaseSessionsDependencies$Dependency r11 = (com.google.firebase.sessions.api.FirebaseSessionsDependencies.Dependency) r11
            kotlinx.coroutines.sync.Mutex r6 = r11.a()
            r0.f90129a = r5
            r0.f90130b = r8
            r0.f90131c = r7
            r0.f90132d = r6
            r0.f90133f = r5
            r0.f90134g = r2
            r0.f90137j = r3
            java.lang.Object r11 = r6.f(r4, r0)
            if (r11 != r1) goto La1
            return r1
        La1:
            r9 = r5
        La2:
            com.google.firebase.sessions.api.FirebaseSessionsDependencies r11 = com.google.firebase.sessions.api.FirebaseSessionsDependencies.f90125a     // Catch: java.lang.Throwable -> Lb0
            com.google.firebase.sessions.api.SessionSubscriber r11 = r11.d(r7)     // Catch: java.lang.Throwable -> Lb0
            r6.i(r4)
            r5.put(r2, r11)
            r5 = r9
            goto L6b
        Lb0:
            r11 = move-exception
            r6.i(r4)
            throw r11
        Lb5:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.api.FirebaseSessionsDependencies.c(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final SessionSubscriber d(SessionSubscriber.Name subscriberName) {
        Intrinsics.checkNotNullParameter(subscriberName, "subscriberName");
        SessionSubscriber sessionSubscriberB = b(subscriberName).b();
        if (sessionSubscriberB != null) {
            return sessionSubscriberB;
        }
        throw new IllegalStateException("Subscriber " + subscriberName + " has not been registered.");
    }
}
