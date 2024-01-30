# KCL Artifact Library for SDKs

This repo mainly includes the binding of the low-level API and spec of the [KCL language core](https://github.com/kcl-lang/kcl), and the SDKs of various languages are based on this to encapsulate higher-level APIs.

## Rust

```shell
cargo add --git https://github.com/kcl-lang/lib --branch main
```

Write the Code

```rust
use kcl_lang::*;
use anyhow::Result;

fn main() -> Result<()> {
    let api = API::new()?;
    let args = &ExecProgramArgs {
        k_filename_list: vec!["main.k".to_string()],
        k_code_list: vec!["a = 1".to_string()],
        ..Default::default()
    };
    let exec_result = api.exec_program(args)?;
    println!("{}", exec_result.yaml_result);
    Ok(())
}
```

## Go

```shell
go get kcl-lang.io/lib
```

Write the Code

```go
package main

import (
	"kcl-lang.io/lib"
)

func main() {
    path = "path/to/install/lib"
    _ := lib.InstallKclvm(path)
}
```

## Java

### Maven

Generally, you can first add the `os-maven-plugin` to automatically detect the classifier based on your platform:

```xml
<build>
<extensions>
  <extension>
    <groupId>kr.motd.maven</groupId>
    <artifactId>os-maven-plugin</artifactId>
    <version>1.7.0</version>
  </extension>
</extensions>
</build>
```

Then add the dependency to `kcl-lib` as follows:

```xml
<dependencies>
<dependency>
  <groupId>com.kcl</groupId>
  <artifactId>kcl-lib</artifactId>
  <version>${kcl_lib.version}</version>
</dependency>
<dependency>
  <groupId>com.kcl</groupId>
  <artifactId>kcl-lib</artifactId>
  <version>${kcl_lib.version}</version>
  <classifier>${os.detected.classifier}</classifier>
</dependency>
</dependencies>
```

### Gradle

For Gradle, you can first add the `com.google.osdetector` to automatically detect the classifier based on your platform:


```groovy
plugins {
    id "com.google.osdetector" version "1.7.3"
}
```

Then add the dependency to `kcl-lib` as follows:

```groovy
dependencies {
    implementation "com.kcl:kcl-lib:0.7.5"
    implementation "com.kcl:kcl-lib:0.7.5:$osdetector.classifier"
}
```

Write the code

```java
import com.kcl.api.API;
import com.kcl.api.Spec.*;
import com.kcl.ast.Program;
import com.kcl.util.JsonUtil;

public class Main {
    public void testProgramSymbols() throws Exception {
        API api = new API();
        LoadPackage_Result result = api.loadPackage(
                LoadPackage_Args.newBuilder().setResolveAst(true).setParseArgs(
                        ParseProgram_Args.newBuilder().addPaths("./src/test_data/schema.k").build())
                        .build());
        String programString = result.getProgram();
        Program program = JsonUtil.deserializeProgram(programString);
        result.getSymbolsMap().values().forEach(s -> System.out.println(s));
    }
}
```

See [here](./java/README.md) for more information.

## Python

```shell
python3 -m pip install kcl_lib
```

Write the code

```python
import kcl_lib.api as api

args = api.ExecProgram_Args(k_filename_list=["./tests/test_data/schema.k"])
api = api.API()
result = api.exec_program(args)
print(result.yaml_result)
```
