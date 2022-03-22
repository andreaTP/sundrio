/**
 * Copyright 2015 The original authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
**/

package io.sundr.model.visitors;

import java.util.List;
import java.util.stream.Collectors;

import io.sundr.builder.Visitor;
import io.sundr.model.Attributeable;
import io.sundr.model.ClassRef;
import io.sundr.model.TypeDefFluent;
import io.sundr.model.utils.Parsers;
import io.sundr.utils.Strings;

public class ApplyImportsFromResources implements Visitor<TypeDefFluent<?>> {

  private final List<ClassRef> imports;

  public ApplyImportsFromResources(String resourceName) {
    this.imports = Parsers.parseImports(Strings.loadResourceQuietly(resourceName));
  }

  @Override
  public void visit(TypeDefFluent<?> type) {
    type.addToAttributes(Attributeable.ALSO_IMPORT, imports);
  }
}
