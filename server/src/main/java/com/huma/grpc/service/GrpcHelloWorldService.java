package com.huma.grpc.service;

import com.huma.grpc.HelloWorldServiceGrpc;
import com.huma.grpc.RpcReq;
import com.huma.grpc.RpcResp;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * @author hudenian
 * @date 2021/7/16
 */
@Slf4j
@GrpcService
public class GrpcHelloWorldService extends HelloWorldServiceGrpc.HelloWorldServiceImplBase {
    @Override
    public void sayHello(RpcReq request, StreamObserver<RpcResp> responseObserver) {
        log.info("server received {}", request);

        String message = "Hello: " + request.getName() + ".you is:" + request.getSchool() + " student !";
        RpcResp rpcResp = RpcResp.newBuilder().setResult(message).build();
        log.info("server responded {}", rpcResp);

        responseObserver.onNext(rpcResp);
        responseObserver.onCompleted();
    }
}
