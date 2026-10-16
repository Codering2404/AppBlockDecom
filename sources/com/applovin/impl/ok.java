package com.applovin.impl;

import com.applovin.impl.p1;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ok implements p1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f62333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f62334c = 1.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f62335d = 1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private p1.a f62336e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private p1.a f62337f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private p1.a f62338g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private p1.a f62339h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f62340i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private nk f62341j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ByteBuffer f62342k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ShortBuffer f62343l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ByteBuffer f62344m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f62345n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f62346o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f62347p;

    public ok() {
        p1.a aVar = p1.a.f62401e;
        this.f62336e = aVar;
        this.f62337f = aVar;
        this.f62338g = aVar;
        this.f62339h = aVar;
        ByteBuffer byteBuffer = p1.f62400a;
        this.f62342k = byteBuffer;
        this.f62343l = byteBuffer.asShortBuffer();
        this.f62344m = byteBuffer;
        this.f62333b = -1;
    }

    @Override // com.applovin.impl.p1
    public p1.a a(p1.a aVar) throws p1.b {
        if (aVar.f62404c != 2) {
            throw new p1.b(aVar);
        }
        int i3 = this.f62333b;
        if (i3 == -1) {
            i3 = aVar.f62402a;
        }
        this.f62336e = aVar;
        p1.a aVar2 = new p1.a(i3, aVar.f62403b, 2);
        this.f62337f = aVar2;
        this.f62340i = true;
        return aVar2;
    }

    @Override // com.applovin.impl.p1
    public void b() {
        if (f()) {
            p1.a aVar = this.f62336e;
            this.f62338g = aVar;
            p1.a aVar2 = this.f62337f;
            this.f62339h = aVar2;
            if (this.f62340i) {
                this.f62341j = new nk(aVar.f62402a, aVar.f62403b, this.f62334c, this.f62335d, aVar2.f62402a);
            } else {
                nk nkVar = this.f62341j;
                if (nkVar != null) {
                    nkVar.a();
                }
            }
        }
        this.f62344m = p1.f62400a;
        this.f62345n = 0L;
        this.f62346o = 0L;
        this.f62347p = false;
    }

    @Override // com.applovin.impl.p1
    public boolean c() {
        if (!this.f62347p) {
            return false;
        }
        nk nkVar = this.f62341j;
        return nkVar == null || nkVar.b() == 0;
    }

    @Override // com.applovin.impl.p1
    public ByteBuffer d() {
        int iB;
        nk nkVar = this.f62341j;
        if (nkVar != null && (iB = nkVar.b()) > 0) {
            if (this.f62342k.capacity() < iB) {
                ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(iB).order(ByteOrder.nativeOrder());
                this.f62342k = byteBufferOrder;
                this.f62343l = byteBufferOrder.asShortBuffer();
            } else {
                this.f62342k.clear();
                this.f62343l.clear();
            }
            nkVar.a(this.f62343l);
            this.f62346o += (long) iB;
            this.f62342k.limit(iB);
            this.f62344m = this.f62342k;
        }
        ByteBuffer byteBuffer = this.f62344m;
        this.f62344m = p1.f62400a;
        return byteBuffer;
    }

    @Override // com.applovin.impl.p1
    public void e() {
        nk nkVar = this.f62341j;
        if (nkVar != null) {
            nkVar.e();
        }
        this.f62347p = true;
    }

    @Override // com.applovin.impl.p1
    public boolean f() {
        if (this.f62337f.f62402a != -1) {
            return Math.abs(this.f62334c - 1.0f) >= 1.0E-4f || Math.abs(this.f62335d - 1.0f) >= 1.0E-4f || this.f62337f.f62402a != this.f62336e.f62402a;
        }
        return false;
    }

    @Override // com.applovin.impl.p1
    public void reset() {
        this.f62334c = 1.0f;
        this.f62335d = 1.0f;
        p1.a aVar = p1.a.f62401e;
        this.f62336e = aVar;
        this.f62337f = aVar;
        this.f62338g = aVar;
        this.f62339h = aVar;
        ByteBuffer byteBuffer = p1.f62400a;
        this.f62342k = byteBuffer;
        this.f62343l = byteBuffer.asShortBuffer();
        this.f62344m = byteBuffer;
        this.f62333b = -1;
        this.f62340i = false;
        this.f62341j = null;
        this.f62345n = 0L;
        this.f62346o = 0L;
        this.f62347p = false;
    }

    public long a(long j3) {
        if (this.f62346o >= 1024) {
            long jC = this.f62345n - ((long) ((nk) b1.a(this.f62341j)).c());
            int i3 = this.f62339h.f62402a;
            int i4 = this.f62338g.f62402a;
            if (i3 == i4) {
                return xp.c(j3, jC, this.f62346o);
            }
            return xp.c(j3, jC * ((long) i3), this.f62346o * ((long) i4));
        }
        return (long) (((double) this.f62334c) * j3);
    }

    public void b(float f3) {
        if (this.f62334c != f3) {
            this.f62334c = f3;
            this.f62340i = true;
        }
    }

    @Override // com.applovin.impl.p1
    public void a(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            nk nkVar = (nk) b1.a(this.f62341j);
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            int iRemaining = byteBuffer.remaining();
            this.f62345n += (long) iRemaining;
            nkVar.b(shortBufferAsShortBuffer);
            byteBuffer.position(byteBuffer.position() + iRemaining);
        }
    }

    public void a(float f3) {
        if (this.f62335d != f3) {
            this.f62335d = f3;
            this.f62340i = true;
        }
    }
}
