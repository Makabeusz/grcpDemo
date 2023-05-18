package com.griddynamics.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class CalculatorServer {

  public static void main(String[] args) throws Exception {
    Server server = ServerBuilder
        .forPort(8080)
        .addService(new CalculatorServiceImpl())
        .build();
    server.start();
    server.awaitTermination();
  }
}
