package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@ElementTypesAreNonnullByDefault
final class MessageDigestHashFunction extends AbstractHashFunction implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MessageDigest f85128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f85129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f85130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f85131d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class MessageDigestHasher extends AbstractByteHasher {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final MessageDigest f85132b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f85133c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f85134d;

        private void o() {
            Preconditions.A(!this.f85134d, "Cannot re-use a Hasher after calling hash() on it");
        }

        @Override // com.google.common.hash.Hasher
        public HashCode i() {
            o();
            this.f85134d = true;
            return this.f85133c == this.f85132b.getDigestLength() ? HashCode.f(this.f85132b.digest()) : HashCode.f(Arrays.copyOf(this.f85132b.digest(), this.f85133c));
        }

        @Override // com.google.common.hash.AbstractByteHasher
        protected void l(byte b3) {
            o();
            this.f85132b.update(b3);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        protected void n(byte[] bArr, int i3, int i4) {
            o();
            this.f85132b.update(bArr, i3, i4);
        }

        private MessageDigestHasher(MessageDigest messageDigest, int i3) {
            this.f85132b = messageDigest;
            this.f85133c = i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f85135a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f85136b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f85137c;

        private Object readResolve() {
            return new MessageDigestHashFunction(this.f85135a, this.f85136b, this.f85137c);
        }

        private SerializedForm(String str, int i3, String str2) {
            this.f85135a = str;
            this.f85136b = i3;
            this.f85137c = str2;
        }
    }

    MessageDigestHashFunction(String str, String str2) {
        MessageDigest messageDigestD = d(str);
        this.f85128a = messageDigestD;
        this.f85129b = messageDigestD.getDigestLength();
        this.f85131d = (String) Preconditions.t(str2);
        this.f85130c = e(messageDigestD);
    }

    private static MessageDigest d(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e3) {
            throw new AssertionError(e3);
        }
    }

    private static boolean e(MessageDigest messageDigest) {
        try {
            messageDigest.clone();
            return true;
        } catch (CloneNotSupportedException unused) {
            return false;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.common.hash.HashFunction
    public int a() {
        return this.f85129b * 8;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher b() {
        if (this.f85130c) {
            try {
                return new MessageDigestHasher((MessageDigest) this.f85128a.clone(), this.f85129b);
            } catch (CloneNotSupportedException unused) {
            }
        }
        return new MessageDigestHasher(d(this.f85128a.getAlgorithm()), this.f85129b);
    }

    public String toString() {
        return this.f85131d;
    }

    Object writeReplace() {
        return new SerializedForm(this.f85128a.getAlgorithm(), this.f85129b, this.f85131d);
    }

    MessageDigestHashFunction(String str, int i3, String str2) {
        this.f85131d = (String) Preconditions.t(str2);
        MessageDigest messageDigestD = d(str);
        this.f85128a = messageDigestD;
        int digestLength = messageDigestD.getDigestLength();
        Preconditions.i(i3 >= 4 && i3 <= digestLength, "bytes (%s) must be >= 4 and < %s", i3, digestLength);
        this.f85129b = i3;
        this.f85130c = e(messageDigestD);
    }
}
