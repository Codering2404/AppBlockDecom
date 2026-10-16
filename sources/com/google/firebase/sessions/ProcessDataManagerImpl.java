package com.google.firebase.sessions;

import android.content.Context;
import android.os.Process;
import com.google.firebase.sessions.ProcessDataManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes6.dex */
@Singleton
@Metadata
public final class ProcessDataManagerImpl implements ProcessDataManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f89998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f89999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f90000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f90001d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Lazy f90002e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f90003f;

    public ProcessDataManagerImpl(Context appContext, final UuidGenerator uuidGenerator) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(uuidGenerator, "uuidGenerator");
        this.f89998a = appContext;
        this.f89999b = LazyKt.b(new Function0() { // from class: com.google.firebase.sessions.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProcessDataManagerImpl.p(this.f90154a);
            }
        });
        this.f90000c = Process.myPid();
        this.f90001d = LazyKt.b(new Function0() { // from class: com.google.firebase.sessions.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProcessDataManagerImpl.q(uuidGenerator);
            }
        });
        this.f90002e = LazyKt.b(new Function0() { // from class: com.google.firebase.sessions.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProcessDataManagerImpl.o(this.f90156a);
            }
        });
    }

    private final List j() {
        return ProcessDetailsProvider.f90010a.a(this.f89998a);
    }

    private final ProcessDetails l() {
        return (ProcessDetails) this.f90002e.getValue();
    }

    private final boolean n(ProcessDetails processDetails, ProcessData processData) {
        return Intrinsics.areEqual(a(), processDetails.c()) ? (processDetails.b() == processData.a() && Intrinsics.areEqual(m(), processData.b())) ? false : true : processDetails.b() != processData.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProcessDetails o(ProcessDataManagerImpl processDataManagerImpl) {
        return ProcessDetailsProvider.f90010a.b(processDataManagerImpl.f89998a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String p(ProcessDataManagerImpl processDataManagerImpl) {
        return processDataManagerImpl.l().c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String q(UuidGenerator uuidGenerator) {
        String string = uuidGenerator.next().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @Override // com.google.firebase.sessions.ProcessDataManager
    public String a() {
        return (String) this.f89999b.getValue();
    }

    @Override // com.google.firebase.sessions.ProcessDataManager
    public boolean b(Map processDataMap) {
        Intrinsics.checkNotNullParameter(processDataMap, "processDataMap");
        ProcessData processData = (ProcessData) processDataMap.get(a());
        return (processData != null && processData.a() == k() && Intrinsics.areEqual(processData.b(), m())) ? false : true;
    }

    @Override // com.google.firebase.sessions.ProcessDataManager
    public Map c(Map map) {
        Map mutableMap;
        if (map != null && (mutableMap = MapsKt.toMutableMap(map)) != null) {
            mutableMap.put(a(), new ProcessData(Process.myPid(), m()));
            Map map2 = MapsKt.toMap(mutableMap);
            if (map2 != null) {
                return map2;
            }
        }
        return MapsKt.mapOf(TuplesKt.a(a(), new ProcessData(Process.myPid(), m())));
    }

    @Override // com.google.firebase.sessions.ProcessDataManager
    public void d() {
        this.f90003f = true;
    }

    @Override // com.google.firebase.sessions.ProcessDataManager
    public boolean e(Map processDataMap) {
        Intrinsics.checkNotNullParameter(processDataMap, "processDataMap");
        if (this.f90003f) {
            return false;
        }
        List<ProcessDetails> listJ = j();
        ArrayList arrayList = new ArrayList();
        for (ProcessDetails processDetails : listJ) {
            ProcessData processData = (ProcessData) processDataMap.get(processDetails.c());
            Pair pair = processData != null ? new Pair(processDetails, processData) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        if (arrayList.isEmpty()) {
            return true;
        }
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            Pair pair2 = (Pair) obj;
            if (!n((ProcessDetails) pair2.a(), (ProcessData) pair2.b())) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.firebase.sessions.ProcessDataManager
    public Map f() {
        return ProcessDataManager.DefaultImpls.a(this);
    }

    public int k() {
        return this.f90000c;
    }

    public String m() {
        return (String) this.f90001d.getValue();
    }
}
