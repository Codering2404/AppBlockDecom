package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.selects.SelectInstance;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class BroadcastChannelImpl<E> extends BufferedChannel<E> implements BroadcastChannel<E> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f141039n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ReentrantLock f141040o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private List f141041p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Object f141042q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final HashMap f141043r;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class SubscriberBuffered extends BufferedChannel<E> {
        /* JADX WARN: Multi-variable type inference failed */
        public SubscriberBuffered() {
            super(BroadcastChannelImpl.this.L1(), null, 2, 0 == true ? 1 : 0);
        }

        @Override // kotlinx.coroutines.channels.BufferedChannel
        /* JADX INFO: renamed from: I1, reason: merged with bridge method [inline-methods] */
        public boolean W(Throwable th) {
            ReentrantLock reentrantLock = BroadcastChannelImpl.this.f141040o;
            BroadcastChannelImpl broadcastChannelImpl = BroadcastChannelImpl.this;
            reentrantLock.lock();
            try {
                broadcastChannelImpl.N1(this);
                return super.W(th);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class SubscriberConflated extends ConflatedBufferedChannel<E> {
        public SubscriberConflated() {
            super(1, BufferOverflow.f141063b, null, 4, null);
        }

        @Override // kotlinx.coroutines.channels.BufferedChannel
        /* JADX INFO: renamed from: M1, reason: merged with bridge method [inline-methods] */
        public boolean W(Throwable th) {
            BroadcastChannelImpl.this.N1(this);
            return super.W(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void N1(ReceiveChannel receiveChannel) {
        ReentrantLock reentrantLock = this.f141040o;
        reentrantLock.lock();
        try {
            List list = this.f141041p;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((BufferedChannel) obj) != receiveChannel) {
                    arrayList.add(obj);
                }
            }
            this.f141041p = arrayList;
            Unit unit = Unit.f139807a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    public boolean A() {
        ReentrantLock reentrantLock = this.f141040o;
        reentrantLock.lock();
        try {
            return super.A();
        } finally {
            reentrantLock.unlock();
        }
    }

    public final int L1() {
        return this.f141039n;
    }

    public final Object M1() {
        ReentrantLock reentrantLock = this.f141040o;
        reentrantLock.lock();
        try {
            if (A()) {
                Throwable thL0 = l0();
                if (thL0 == null) {
                    throw new IllegalStateException("This broadcast channel is closed");
                }
                throw thL0;
            }
            if (this.f141042q == BroadcastChannelKt.f141056a) {
                throw new IllegalStateException("No value");
            }
            Object obj = this.f141042q;
            reentrantLock.unlock();
            return obj;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public boolean W(Throwable th) {
        ReentrantLock reentrantLock = this.f141040o;
        reentrantLock.lock();
        try {
            Iterator it = this.f141041p.iterator();
            while (it.hasNext()) {
                ((BufferedChannel) it.next()).W(th);
            }
            this.f141042q = BroadcastChannelKt.f141056a;
            boolean zW = super.W(th);
            reentrantLock.unlock();
            return zW;
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public ReceiveChannel e() {
        ReentrantLock reentrantLock = this.f141040o;
        reentrantLock.lock();
        try {
            Channel subscriberConflated = this.f141039n == -1 ? new SubscriberConflated() : new SubscriberBuffered();
            if (A() && this.f141042q == BroadcastChannelKt.f141056a) {
                subscriberConflated.w(l0());
                reentrantLock.unlock();
                return subscriberConflated;
            }
            if (this.f141042q != BroadcastChannelKt.f141056a) {
                subscriberConflated.h(M1());
            }
            this.f141041p = CollectionsKt.plus((Collection<? extends Channel>) this.f141041p, subscriberConflated);
            reentrantLock.unlock();
            return subscriberConflated;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    public Object h(Object obj) {
        ReentrantLock reentrantLock = this.f141040o;
        reentrantLock.lock();
        try {
            if (A()) {
                return super.h(obj);
            }
            List list = this.f141041p;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (((BufferedChannel) it.next()).v1()) {
                        return ChannelResult.f141130b.b();
                    }
                }
            }
            if (this.f141039n == -1) {
                this.f141042q = obj;
            }
            Iterator it2 = this.f141041p.iterator();
            while (it2.hasNext()) {
                ((BufferedChannel) it2.next()).h(obj);
            }
            return ChannelResult.f141130b.c(Unit.f139807a);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    protected void l1(SelectInstance selectInstance, Object obj) {
        ReentrantLock reentrantLock = this.f141040o;
        reentrantLock.lock();
        try {
            Object objRemove = this.f141043r.remove(selectInstance);
            if (objRemove != null) {
                selectInstance.d(objRemove);
                reentrantLock.unlock();
            } else {
                Unit unit = Unit.f139807a;
                reentrantLock.unlock();
                BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(selectInstance.getContext()), null, CoroutineStart.f140919d, new BroadcastChannelImpl$registerSelectForSend$2(this, obj, selectInstance, null), 1, null);
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        if (this.f141042q != BroadcastChannelKt.f141056a) {
            str = "CONFLATED_ELEMENT=" + this.f141042q + "; ";
        } else {
            str = "";
        }
        sb.append(str);
        sb.append("BROADCAST=<");
        sb.append(super.toString());
        sb.append(">; SUBSCRIBERS=");
        sb.append(CollectionsKt.joinToString$default(this.f141041p, ";", "<", ">", 0, null, null, 56, null));
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    public boolean w(Throwable th) {
        ReentrantLock reentrantLock = this.f141040o;
        reentrantLock.lock();
        try {
            Iterator it = this.f141041p.iterator();
            while (it.hasNext()) {
                ((BufferedChannel) it.next()).w(th);
            }
            List list = this.f141041p;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((BufferedChannel) obj).x0()) {
                    arrayList.add(obj);
                }
            }
            this.f141041p = arrayList;
            boolean zW = super.w(th);
            reentrantLock.unlock();
            return zW;
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x007e -> B:30:0x0081). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object y(java.lang.Object r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.BroadcastChannelImpl$send$1
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.channels.BroadcastChannelImpl$send$1 r0 = (kotlinx.coroutines.channels.BroadcastChannelImpl$send$1) r0
            int r1 = r0.f141055g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f141055g = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.BroadcastChannelImpl$send$1 r0 = new kotlinx.coroutines.channels.BroadcastChannelImpl$send$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f141053d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f141055g
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L33
            java.lang.Object r7 = r0.f141052c
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r2 = r0.f141051b
            java.lang.Object r4 = r0.f141050a
            kotlinx.coroutines.channels.BroadcastChannelImpl r4 = (kotlinx.coroutines.channels.BroadcastChannelImpl) r4
            kotlin.ResultKt.b(r8)
            goto L81
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            r8 = 0
            java.lang.String r8 = cz.mobilesoft.coreblock.storage.room.dao.cI.KrzujOtzIk.yPWioKdBs
            r7.<init>(r8)
            throw r7
        L3c:
            kotlin.ResultKt.b(r8)
            java.util.concurrent.locks.ReentrantLock r8 = r6.f141040o
            r8.lock()
            boolean r2 = r6.A()     // Catch: java.lang.Throwable -> L52
            if (r2 != 0) goto L9a
            int r2 = r6.f141039n     // Catch: java.lang.Throwable -> L52
            r4 = -1
            if (r2 != r4) goto L54
            r6.f141042q = r7     // Catch: java.lang.Throwable -> L52
            goto L54
        L52:
            r7 = move-exception
            goto L9f
        L54:
            java.util.List r2 = r6.f141041p     // Catch: java.lang.Throwable -> L52
            r8.unlock()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r8 = r2.iterator()
            r4 = r8
            r8 = r7
            r7 = r4
            r4 = r6
        L63:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L97
            java.lang.Object r2 = r7.next()
            kotlinx.coroutines.channels.BufferedChannel r2 = (kotlinx.coroutines.channels.BufferedChannel) r2
            r0.f141050a = r4
            r0.f141051b = r8
            r0.f141052c = r7
            r0.f141055g = r3
            java.lang.Object r2 = r2.r1(r8, r0)
            if (r2 != r1) goto L7e
            return r1
        L7e:
            r5 = r2
            r2 = r8
            r8 = r5
        L81:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L95
            boolean r8 = r4.A()
            if (r8 != 0) goto L90
            goto L95
        L90:
            java.lang.Throwable r7 = r4.s0()
            throw r7
        L95:
            r8 = r2
            goto L63
        L97:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        L9a:
            java.lang.Throwable r7 = r6.s0()     // Catch: java.lang.Throwable -> L52
            throw r7     // Catch: java.lang.Throwable -> L52
        L9f:
            r8.unlock()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BroadcastChannelImpl.y(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
