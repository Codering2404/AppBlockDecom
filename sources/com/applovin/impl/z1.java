package com.applovin.impl;

import com.applovin.impl.p1;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class z1 implements p1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected p1.a f65285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected p1.a f65286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private p1.a f65287d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private p1.a f65288e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ByteBuffer f65289f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ByteBuffer f65290g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f65291h;

    public z1() {
        ByteBuffer byteBuffer = p1.f62400a;
        this.f65289f = byteBuffer;
        this.f65290g = byteBuffer;
        p1.a aVar = p1.a.f62401e;
        this.f65287d = aVar;
        this.f65288e = aVar;
        this.f65285b = aVar;
        this.f65286c = aVar;
    }

    @Override // com.applovin.impl.p1
    public final p1.a a(p1.a aVar) {
        this.f65287d = aVar;
        this.f65288e = b(aVar);
        return f() ? this.f65288e : p1.a.f62401e;
    }

    protected abstract p1.a b(p1.a aVar);

    @Override // com.applovin.impl.p1
    public final void b() {
        this.f65290g = p1.f62400a;
        this.f65291h = false;
        this.f65285b = this.f65287d;
        this.f65286c = this.f65288e;
        g();
    }

    @Override // com.applovin.impl.p1
    public boolean c() {
        return this.f65291h && this.f65290g == p1.f62400a;
    }

    @Override // com.applovin.impl.p1
    public ByteBuffer d() {
        ByteBuffer byteBuffer = this.f65290g;
        this.f65290g = p1.f62400a;
        return byteBuffer;
    }

    @Override // com.applovin.impl.p1
    public final void e() {
        this.f65291h = true;
        h();
    }

    @Override // com.applovin.impl.p1
    public boolean f() {
        return this.f65288e != p1.a.f62401e;
    }

    @Override // com.applovin.impl.p1
    public final void reset() {
        b();
        this.f65289f = p1.f62400a;
        p1.a aVar = p1.a.f62401e;
        this.f65287d = aVar;
        this.f65288e = aVar;
        this.f65285b = aVar;
        this.f65286c = aVar;
        i();
    }

    protected final boolean a() {
        return this.f65290g.hasRemaining();
    }

    protected final ByteBuffer a(int i3) {
        if (this.f65289f.capacity() < i3) {
            this.f65289f = ByteBuffer.allocateDirect(i3).order(ByteOrder.nativeOrder());
        } else {
            this.f65289f.clear();
        }
        ByteBuffer byteBuffer = this.f65289f;
        this.f65290g = byteBuffer;
        return byteBuffer;
    }

    protected void g() {
    }

    protected void h() {
    }

    protected void i() {
    }
}
