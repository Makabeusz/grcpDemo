package com.griddynamics.grpc;

import com.griddynamics.grpc.CalculatorServiceGrpc.CalculatorServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Scanner;

public class CalculatorClient {

  private static final ManagedChannel channel
      = ManagedChannelBuilder.forAddress("localhost", 8080)
      .usePlaintext()
      .build();
  private static final CalculatorServiceBlockingStub stub = CalculatorServiceGrpc.newBlockingStub(channel);

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int first;
    int second;
    while (true) {
      System.out.println("first number: ");
      first = Integer.parseInt(scanner.nextLine());
      System.out.println("second number: ");
      second = Integer.parseInt(scanner.nextLine());

      SolutionResponse response = stub.sum(NumbersRequest.newBuilder()
          .setFirst(first)
          .setSecond(second)
          .build());

      System.out.println("Response: " + response);
      System.out.println("type \"N\" to quit or anything else to continue.");
      String exit = scanner.nextLine();
      if (exit.equalsIgnoreCase("n")) {
        break;
      }
    }
    channel.shutdown();
  }
}
