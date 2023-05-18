package com.griddynamics.grpc;

import com.griddynamics.grpc.CalculatorServiceGrpc.CalculatorServiceImplBase;
import io.grpc.stub.StreamObserver;

public class CalculatorServiceImpl extends CalculatorServiceImplBase {

  @Override
  public void sum(NumbersRequest request, StreamObserver<SolutionResponse> responseObserver) {
    int first = request.getFirst();
    int second = request.getSecond();
    double result = first + second;

    responseObserver.onNext(SolutionResponse.newBuilder()
        .setResult(result)
        .build());
    responseObserver.onCompleted();

  }
}
