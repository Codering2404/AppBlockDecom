package com.google.maps.android.compose;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.google.maps.android.compose.MapNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

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
@Metadata
public final class InputHandlerNode implements MapNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableState f90853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableState f90854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableState f90855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableState f90856d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MutableState f90857e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MutableState f90858f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MutableState f90859g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final MutableState f90860h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MutableState f90861i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final MutableState f90862j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final MutableState f90863k;

    public InputHandlerNode(Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, Function1 function17, Function1 function18, Function1 function19, Function1 function110, Function1 function111) {
        this.f90853a = SnapshotStateKt__SnapshotStateKt.e(function1, null, 2, null);
        this.f90854b = SnapshotStateKt__SnapshotStateKt.e(function12, null, 2, null);
        this.f90855c = SnapshotStateKt__SnapshotStateKt.e(function13, null, 2, null);
        this.f90856d = SnapshotStateKt__SnapshotStateKt.e(function14, null, 2, null);
        this.f90857e = SnapshotStateKt__SnapshotStateKt.e(function15, null, 2, null);
        this.f90858f = SnapshotStateKt__SnapshotStateKt.e(function16, null, 2, null);
        this.f90859g = SnapshotStateKt__SnapshotStateKt.e(function17, null, 2, null);
        this.f90860h = SnapshotStateKt__SnapshotStateKt.e(function18, null, 2, null);
        this.f90861i = SnapshotStateKt__SnapshotStateKt.e(function19, null, 2, null);
        this.f90862j = SnapshotStateKt__SnapshotStateKt.e(function110, null, 2, null);
        this.f90863k = SnapshotStateKt__SnapshotStateKt.e(function111, null, 2, null);
    }

    @Override // com.google.maps.android.compose.MapNode
    public void a() {
        MapNode.DefaultImpls.a(this);
    }

    @Override // com.google.maps.android.compose.MapNode
    public void b() {
        MapNode.DefaultImpls.b(this);
    }

    @Override // com.google.maps.android.compose.MapNode
    public void c() {
        MapNode.DefaultImpls.c(this);
    }

    public final Function1 d() {
        return (Function1) this.f90853a.getValue();
    }

    public final Function1 e() {
        return (Function1) this.f90854b.getValue();
    }

    public final Function1 f() {
        return (Function1) this.f90858f.getValue();
    }

    public final Function1 g() {
        return (Function1) this.f90859g.getValue();
    }

    public final Function1 h() {
        return (Function1) this.f90860h.getValue();
    }

    public final Function1 i() {
        return (Function1) this.f90857e.getValue();
    }

    public final Function1 j() {
        return (Function1) this.f90861i.getValue();
    }

    public final Function1 k() {
        return (Function1) this.f90862j.getValue();
    }

    public final Function1 l() {
        return (Function1) this.f90863k.getValue();
    }

    public final Function1 m() {
        return (Function1) this.f90855c.getValue();
    }

    public final Function1 n() {
        return (Function1) this.f90856d.getValue();
    }

    public final void o(Function1 function1) {
        this.f90853a.setValue(function1);
    }

    public final void p(Function1 function1) {
        this.f90854b.setValue(function1);
    }

    public final void q(Function1 function1) {
        this.f90858f.setValue(function1);
    }

    public final void r(Function1 function1) {
        this.f90859g.setValue(function1);
    }

    public final void s(Function1 function1) {
        this.f90860h.setValue(function1);
    }

    public final void t(Function1 function1) {
        this.f90857e.setValue(function1);
    }

    public final void u(Function1 function1) {
        this.f90861i.setValue(function1);
    }

    public final void v(Function1 function1) {
        this.f90862j.setValue(function1);
    }

    public final void w(Function1 function1) {
        this.f90863k.setValue(function1);
    }

    public final void x(Function1 function1) {
        this.f90855c.setValue(function1);
    }

    public final void y(Function1 function1) {
        this.f90856d.setValue(function1);
    }
}
