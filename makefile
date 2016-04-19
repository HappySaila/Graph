# Makefile for Graph Assignment

LIB = ../lib
SRCDIR = src
BINDIR = bin
TESTDIR = test
DOCDIR = doc

CLI = $(LIB)/cli/commons-cli-1.3.1.jar
ASM = $(LIB)/asm/asm-5.0.4.jar:$(LIB)/asm/asm-commons-5.0.4.jar:$(LIB)/asm/asm-tree-5.0.4.jar
JUNIT = $(LIB)/junit/junit-4.12.jar:$(LIB)/junit/hamcrest-core-1.3.jar
JACOCO = $(LIB)/jacoco/org.jacoco.core-0.7.5.201505241946.jar:$(LIB)/jacoco/org.jacoco.report-0.7.5.201505241946.jar:
TOOLS = $(LIB)/tools

JAVAC = javac
JFLAGS = -g -d $(BINDIR) -cp $(BINDIR):$(JUNIT)


vpath %.java $(SRCDIR)/graph:$(SRCDIR):$(SRCDIR)/utils:$(TESTDIR)
vpath %.class $(BINDIR)/graph:$(BINDIR)/utils:$(BINDIR)

# define general build rule for java sources
.SUFFIXES:  .java  .class

.java.class:
	$(JAVAC)  $(JFLAGS)  $<

#default rule - will be invoked by make
all: Pair.class GraphEntity.class Edge.class Vertex.class Graph.class  \
	AdjacencyMapVertex.class AdjacencyMapEdge.class AdjacencyMapGraph.class \
	ClusterBuilder.class Doublets.class
	
# Rules for dealing with dependencies between GraphEntity and Graph
Graph.class: GraphEntity.class Edge.class Vertex.class

GraphEntity.class: 
	rm -rf $(BINDIR)/graph/GraphEntity.class $(BINDIR)/graph/Graph.class \
	$(BINDIR)/graph/Vertex.class $(BINDIR)/graph/Edge.class
	javac $(JFLAGS) $(SRCDIR)/graph/GraphEntity.java $(SRCDIR)/graph/Graph.java \
	$(SRCDIR)/graph/Vertex.java $(SRCDIR)/graph/Edge.java	

# Rules for dealing with dependencies between AdjacencyMapVertex and AdjacencyMapEdge
AdjacencyMapVertex.class: AdjacencyMapEdge.class

AdjacencyMapEdge.class:
	rm -rf $(BINDIR)/graph/AdjacencyMapEdge.class $(BINDIR)/graph/AdjacencyMapVertex.class
	javac $(JFLAGS) $(SRCDIR)/graph/AdjacencyMapEdge.java $(SRCDIR)/graph/AdjacencyMapVertex.java
        		
# Rules for generating documentation
doc: all
	javadoc -d $(DOCDIR) -link http://docs.oracle.com/javase/8/docs/api/ $(SRCDIR)/graph/*.java $(SRCDIR)/utils/*.java $(SRCDIR)/Doublets.java

# Rules for unit testing
# Add additional Testxx.class file to this line and to TestSuite.java
test_classes: all TestClusterBuilder.class TestSuite.class

test: test_classes
	java -ea -cp $(BINDIR):$(JUNIT) org.junit.runner.JUnitCore TestSuite
	
# Rules for generating tests
jacoco.exec: test_classes
	java -ea -javaagent:$(LIB)/jacoco/jacocoagent.jar -cp $(BINDIR):$(JUNIT) org.junit.runner.JUnitCore TestSuite

report: jacoco.exec
	java -cp $(BINDIR):$(CLI):$(JACOCO):$(ASM):$(TOOLS) Report --reporttype html .

clean:
	@echo "Removing class files, coverage traces and reports."
	@rm -f  $(BINDIR)/*.class
	@rm -f $(BINDIR)/*/*.class
	@rm -f jacoco.exec *.xml *.csv
	@rm -Rf coveragereport
	@rm -Rf doc
