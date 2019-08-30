package com.hai.yun;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;

public class MinaTcpServer extends IoHandlerAdapter {
    public static final int PORT = 18567;
    private final NioSocketAcceptor acceptor;

    private IoSession mSession;

    public MinaTcpServer() throws IOException {
        acceptor = new NioSocketAcceptor();
        acceptor.setHandler(this);
        acceptor.bind(new InetSocketAddress(PORT));

        System.out.println("TCP服务启动，端口=" + PORT);
    }

    public void close() {
        acceptor.dispose();
    }


    @Override
    public void sessionOpened(IoSession session) throws Exception {



        System.out.println("会话打开");

    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        super.messageSent(session, message);
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        System.out.println("断开连接了");

    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        mSession=session;
        IoBuffer ioBuffer = (IoBuffer) message;
        byte[] msg = new byte[ioBuffer.limit()];
        ioBuffer.get(msg, ioBuffer.position(), ioBuffer.limit());
        System.out.print("收到客户端信息：");
        for (byte b : msg) {
            System.out.print("|" + BinaryUtils.byteToOx(BinaryUtils.getInt(b)));
        }
        byte[] bytes1 = new byte[]{0x71, 0x78, 0x0B, 0x01, 0x00, 0x01,
                0x12, 0x01, 0x08, 0x09, 0x1e, 0x0a,
                BinaryUtils.getByte(0xd9),
                BinaryUtils.getByte(0xdc), 0x0d, 0x0a};

        byte[] bytes2 = new byte[]{0x72, 0x78, 0x05, 0x01, 0x00, 0x01,
                0x12, 0x01, 0x08, 0x09, 0x1e, 0x0a,
                BinaryUtils.getByte(217),
                BinaryUtils.getByte(0xdc), 0x0d, 0x0a};
        byte[] bytes3 = new byte[]{0x73, 0x78, 0x0B, 0x01, 0x00, 0x01,
                0x12, 0x01, 0x08, 0x09,0x78, 0x0B, 0x01, 0x00, 0x1e, 0x0a,
                BinaryUtils.getByte(0xd9),
                BinaryUtils.getByte(0xdc), 0x0d, 0x0a};

        byte[] bytes4 = new byte[]{0x74,0x78, 0x0B, 0x01, 0x00, 0x78, 0x05, 0x01, 0x00, 0x01,
                0x12, 0x01, 0x08, 0x09, 0x78, 0x0B, 0x01, 0x00,0x1e, 0x0a,
                BinaryUtils.getByte(217),
                BinaryUtils.getByte(0xdc), 0x0d, 0x0a};

        byte[] bytes5 = new byte[]{0x75, 0x78, 0x0B, 0x01, 0x00, 0x01,
                0x12, 0x01, 0x08, 0x09, 0x1e, 0x0a,
                BinaryUtils.getByte(0xd9),
                BinaryUtils.getByte(0xdc), 0x0d, 0x0a};

        byte[] bytes6 = new byte[]{0x76, 0x78, 0x05, 0x01, 0x00, 0x01,
                0x12, 0x01, 0x08, 0x09, 0x1e, 0x0a,
                BinaryUtils.getByte(217),
                BinaryUtils.getByte(0xdc), 0x0d, 0x0a};
        byte[] bytes7 = new byte[]{0x77, 0x78, 0x0B, 0x01, 0x00, 0x01,
                0x12, 0x01, 0x08, 0x09, 0x1e, 0x0a,
                BinaryUtils.getByte(0xd9),
                BinaryUtils.getByte(0xdc), 0x0d, 0x0a};

        byte[] bytes8 = new byte[]{0x78, 0x78, 0x05, 0x01, 0x00, 0x01,
                0x12, 0x01, 0x08, 0x09, 0x1e, 0x0a,
                BinaryUtils.getByte(217),
                BinaryUtils.getByte(0xdc), 0x0d, 0x0a};

        for (int i = 0; i < 10; i++) {

            mSession.write(IoBuffer.wrap(bytes1));
            mSession.write(IoBuffer.wrap(bytes2));
            mSession.write(IoBuffer.wrap(bytes3));
            mSession.write(IoBuffer.wrap(bytes4));
            mSession.write(IoBuffer.wrap(bytes5));
            mSession.write(IoBuffer.wrap(bytes6));
            mSession.write(IoBuffer.wrap(bytes7));
            mSession.write(IoBuffer.wrap(bytes8));
        }





    }
}
