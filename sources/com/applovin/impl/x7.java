package com.applovin.impl;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class x7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteArrayOutputStream f64869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DataOutputStream f64870b;

    public x7() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.f64869a = byteArrayOutputStream;
        this.f64870b = new DataOutputStream(byteArrayOutputStream);
    }

    public byte[] a(v7 v7Var) {
        this.f64869a.reset();
        try {
            a(this.f64870b, v7Var.f64400a);
            String str = v7Var.f64401b;
            if (str == null) {
                str = "";
            }
            a(this.f64870b, str);
            this.f64870b.writeLong(v7Var.f64402c);
            this.f64870b.writeLong(v7Var.f64403d);
            this.f64870b.write(v7Var.f64404f);
            this.f64870b.flush();
            return this.f64869a.toByteArray();
        } catch (IOException e3) {
            throw new RuntimeException(e3);
        }
    }

    private static void a(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }
}
