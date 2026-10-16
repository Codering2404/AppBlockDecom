package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.MapEntryLite;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@CheckReturnValue
interface Writer {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum FieldOrder {
        ASCENDING,
        DESCENDING
    }

    void A(int i3, List list, boolean z2);

    void B(int i3, List list, boolean z2);

    void C(int i3, float f3);

    void D(int i3);

    void E(int i3, List list, boolean z2);

    void F(int i3, int i4);

    void G(int i3, List list, boolean z2);

    void H(int i3, List list, boolean z2);

    void I(int i3, int i4);

    void J(int i3, List list);

    void K(int i3, MapEntryLite.Metadata metadata, Map map);

    void L(int i3, Object obj, Schema schema);

    void M(int i3, List list, Schema schema);

    void N(int i3, ByteString byteString);

    void O(int i3, Object obj, Schema schema);

    void P(int i3, List list, Schema schema);

    void a(int i3, List list, boolean z2);

    void b(int i3, Object obj);

    void c(int i3, int i4);

    void d(int i3, List list);

    void e(int i3, String str);

    void f(int i3, long j3);

    void g(int i3, List list, boolean z2);

    void h(int i3, int i4);

    void i(int i3, long j3);

    void j(int i3, List list, boolean z2);

    void k(int i3, List list, boolean z2);

    void l(int i3, List list, boolean z2);

    void m(int i3, long j3);

    void n(int i3, List list, boolean z2);

    void o(int i3, int i4);

    void p(int i3, double d3);

    void q(int i3, List list, boolean z2);

    void r(int i3, List list, boolean z2);

    void s(int i3, long j3);

    FieldOrder t();

    void u(int i3, Object obj);

    void v(int i3, long j3);

    void w(int i3, boolean z2);

    void x(int i3, int i4);

    void y(int i3);

    void z(int i3, List list, boolean z2);
}
